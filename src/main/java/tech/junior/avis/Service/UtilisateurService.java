package tech.junior.avis.Service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.junior.avis.entity.Role;
import tech.junior.avis.entity.TypeDeRole;
import tech.junior.avis.entity.Utilisateur;
import tech.junior.avis.repository.UtilisateurRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public void inscription(Utilisateur utilisateur){

        if (!utilisateur.getEmail().contains("@")) {
            throw new RuntimeException("Votre mail est invadide");
        }
        if (!utilisateur.getEmail().contains(".")) {
            throw new RuntimeException("Votre mail est invadide");
        }
        Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()){
            throw new RuntimeException("Cette adresse est déja utilisé");
        }

        String mdpCrypte = this.passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(mdpCrypte);

        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
        utilisateur.setRole(roleUtilisateur);

        this.utilisateurRepository.save(utilisateur);


    }
}
