package project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

// VUE MATERIALISER
@Entity
@Table(name = "participants_accepter")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantsAccepter {
    @Id
    private Long participant_id;

    private String soiree_nom;

    private LocalDateTime date_soiree;

    private Integer place_disponible;

    private Double prix;

    private String description;

    private Long soiree_id;

    private Long utilisateur_id;
}
