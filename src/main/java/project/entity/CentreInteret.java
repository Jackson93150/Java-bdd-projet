package project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "centre_interet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CentreInteret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "centre_interet_id")
    private Long id;

    private String name;
}
