package project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "message"
)@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "contenu", length = 500, nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "participant_id", nullable = false)
    private Participant sender;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id", nullable = false)
    private Utilisateur receiver;
}
