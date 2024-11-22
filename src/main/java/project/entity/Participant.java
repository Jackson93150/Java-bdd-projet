package project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.enumeration.ParticipantStatus;

import java.util.List;

@Entity
@Table(
        name = "participant"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ParticipantStatus status;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "soiree_id", referencedColumnName = "soiree_id")
    private Soiree soiree;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private Note note;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Message> sentMessages;
}
