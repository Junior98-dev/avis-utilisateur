package tech.junior.avis.repository;

import org.springframework.data.repository.CrudRepository;
import tech.junior.avis.entity.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
}
