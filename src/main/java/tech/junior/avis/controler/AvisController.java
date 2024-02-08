package tech.junior.avis.controler;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.junior.avis.Service.AvisService;
import tech.junior.avis.entity.Avis;

@AllArgsConstructor
@RequestMapping("avis")
@RestController
public class AvisController {

    private AvisService avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creer(@RequestBody Avis avis){
        this.avisService.creer(avis);
    }
}
