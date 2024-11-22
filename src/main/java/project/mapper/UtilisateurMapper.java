package project.mapper;

import org.mapstruct.Mapper;
import project.dto.UtilisateurDto;
import project.entity.Utilisateur;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurDto toDto(Utilisateur utilisateur);
    Utilisateur toEntity(UtilisateurDto utilisateurDto);

    List<UtilisateurDto> toDtos(List<Utilisateur> utilisateurs);
    List<Utilisateur> toEntities(List<UtilisateurDto> utilisateurDtos);
}
