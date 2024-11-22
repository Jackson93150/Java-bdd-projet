package project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.entity.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByEmail(String email);

    @Query("SELECT DISTINCT u FROM Utilisateur u " +
            "LEFT JOIN FETCH u.adresse a " +
            "LEFT JOIN FETCH u.centre_interet ci")
    Page<Utilisateur> findAllWithAdressAndCentreInterets(Pageable pageable);

    @Query("SELECT u FROM Utilisateur u " +
            "LEFT JOIN FETCH u.adresse a " +
            "LEFT JOIN FETCH u.centre_interet ci " +
            "WHERE u.id = :id")
    Optional<Utilisateur> findByIdWithAdressAndCentreInterets(@Param("id") Long id);
}
