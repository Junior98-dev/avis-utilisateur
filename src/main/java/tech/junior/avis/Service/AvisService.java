package tech.junior.avis.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.junior.avis.entity.Avis;
import tech.junior.avis.repository.AvisRepository;

@Service
@AllArgsConstructor
public class AvisService {

    private final AvisRepository avisRepository;

    public void creer(Avis avis){
        this.avisRepository.save(avis);
    }
}
