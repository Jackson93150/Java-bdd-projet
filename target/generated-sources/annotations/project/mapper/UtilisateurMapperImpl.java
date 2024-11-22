package project.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.dto.UtilisateurDto;
import project.entity.CentreInteret;
import project.entity.Utilisateur;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T16:26:27+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public UtilisateurDto toDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDto utilisateurDto = new UtilisateurDto();

        utilisateurDto.setId( utilisateur.getId() );
        utilisateurDto.setNom( utilisateur.getNom() );
        utilisateurDto.setPrenom( utilisateur.getPrenom() );
        utilisateurDto.setEmail( utilisateur.getEmail() );
        utilisateurDto.setAge( utilisateur.getAge() );
        Set<CentreInteret> set = utilisateur.getCentre_interet();
        if ( set != null ) {
            utilisateurDto.setCentre_interet( new ArrayList<CentreInteret>( set ) );
        }
        utilisateurDto.setAdresse( utilisateur.getAdresse() );

        return utilisateurDto;
    }

    @Override
    public Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if ( utilisateurDto == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId( utilisateurDto.getId() );
        utilisateur.setNom( utilisateurDto.getNom() );
        utilisateur.setPrenom( utilisateurDto.getPrenom() );
        utilisateur.setEmail( utilisateurDto.getEmail() );
        utilisateur.setAge( utilisateurDto.getAge() );
        List<CentreInteret> list = utilisateurDto.getCentre_interet();
        if ( list != null ) {
            utilisateur.setCentre_interet( new LinkedHashSet<CentreInteret>( list ) );
        }
        utilisateur.setAdresse( utilisateurDto.getAdresse() );

        return utilisateur;
    }

    @Override
    public List<UtilisateurDto> toDtos(List<Utilisateur> utilisateurs) {
        if ( utilisateurs == null ) {
            return null;
        }

        List<UtilisateurDto> list = new ArrayList<UtilisateurDto>( utilisateurs.size() );
        for ( Utilisateur utilisateur : utilisateurs ) {
            list.add( toDto( utilisateur ) );
        }

        return list;
    }

    @Override
    public List<Utilisateur> toEntities(List<UtilisateurDto> utilisateurDtos) {
        if ( utilisateurDtos == null ) {
            return null;
        }

        List<Utilisateur> list = new ArrayList<Utilisateur>( utilisateurDtos.size() );
        for ( UtilisateurDto utilisateurDto : utilisateurDtos ) {
            list.add( toEntity( utilisateurDto ) );
        }

        return list;
    }
}
