package project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "soiree",
        indexes = {
                @Index(name = "idx_soiree_date_soiree", columnList = "date_soiree"),
                @Index(name = "idx_soiree_prix", columnList = "prix"),
                @Index(name = "idx_soiree_type_soiree", columnList = "type_soiree_id")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Soiree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soiree_id")
    private Long id;

    private String nom;

    @Column(name = "date_soiree")
    private LocalDateTime dateSoiree;

    @Column(name = "place_disponible")
    private Integer placeDisponible;

    private Double prix;

    @Column(name = "date_publication", updatable = false)
    private LocalDateTime datePublication;

    @Column(length = 500)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id", referencedColumnName = "adresse_id")
    private Adresse adresse;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisateur_id", referencedColumnName = "utilisateur_id")
    private Utilisateur organisateur;

    @ManyToOne
    @JoinColumn(name = "type_soiree_id", referencedColumnName = "type_soiree_id")
    private TypeSoiree typeSoiree;

    @OneToMany(mappedBy = "soiree", cascade = CascadeType.ALL)
    private List<Participant> participants;

    @OneToMany(mappedBy = "soiree", cascade = CascadeType.ALL)
    private List<Note> notes;

    @PrePersist
    protected void onCreate() {
        this.datePublication = LocalDateTime.now();
    }
}
