package tech.junior.avis.repository;

import org.springframework.data.repository.CrudRepository;
import tech.junior.avis.entity.Avis;

public interface AvisRepository extends CrudRepository<Avis, Integer> {
}
