package project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "note")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;

    @Column(nullable = false)
    private int note;

    @OneToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "participant_id", unique = true)
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "soiree_id", referencedColumnName = "soiree_id")
    private Soiree soiree;
}
