package project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "type_soiree")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeSoiree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_soiree_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "typeSoiree", cascade = CascadeType.ALL)
    private List<Soiree> soirees;
}
