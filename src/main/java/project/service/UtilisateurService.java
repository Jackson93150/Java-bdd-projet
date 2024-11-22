package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import project.dto.*;
import project.entity.Utilisateur;
import project.mapper.UtilisateurMapper;
import project.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UtilisateurMapper utilisateurMapper;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, JwtService jwtService, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.utilisateurMapper = utilisateurMapper;
    }

    public AuthResponseDto register(RegisterRequestDto request) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(request.getNom());
        utilisateur.setPrenom(request.getPrenom());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setAge(request.getAge());
        utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));

        utilisateurRepository.save(utilisateur);

        String token = jwtService.generateToken(utilisateur.getEmail());
        return new AuthResponseDto(token);
    }

    public AuthResponseDto login(AuthRequestDto request) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(request.getPassword(), utilisateur.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        String token = jwtService.generateToken(utilisateur.getEmail());
        return new AuthResponseDto(token);
    }

    public Page<UtilisateurDto> findAll(Pageable pageable) {
        Page<Utilisateur> utilisateurs = utilisateurRepository.findAllWithAdressAndCentreInterets(pageable);
        return utilisateurs.map(utilisateurMapper::toDto);
    }

    public UtilisateurDto findById(Long id) {
        Utilisateur utilisateur = utilisateurRepository.findByIdWithAdressAndCentreInterets(id)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        return utilisateurMapper.toDto(utilisateur);
    }

    public UtilisateurDto update(Long id, UtilisateurDto utilisateurDto) {
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé avec l'ID : " + id));

        utilisateurDto.setId(existingUtilisateur.getId());

        Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateurMapper.toEntity(utilisateurDto));
        return utilisateurMapper.toDto(updatedUtilisateur);
    }

    public void delete(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new NotFoundException("Utilisateur non trouvé avec l'ID : " + id);
        }
        utilisateurRepository.deleteById(id);
    }
}
