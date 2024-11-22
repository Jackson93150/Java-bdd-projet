package project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.entity.Adresse;
import project.entity.CentreInteret;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private Integer age;

    private List<CentreInteret> centre_interet;
    private Adresse adresse;
}
