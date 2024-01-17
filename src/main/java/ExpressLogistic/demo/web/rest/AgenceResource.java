package ExpressLogistic.demo.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExpressLogistic.demo.domaine.Agence;
import ExpressLogistic.demo.service.AgenceService;

@RestController
@RequestMapping("/agence")
public class AgenceResource {
    
    // Propriété du service 
    private final AgenceService agenceService; 

    // Injection du service au niveau du constructeur
    public AgenceResource( AgenceService agenceService) {
        this.agenceService = agenceService;
    }


    // Crétion d'une resource (agence) 
    @PostMapping
    public ResponseEntity<String>  createAgence(@RequestBody Agence agence) {
        this.agenceService.create(agence);
        return ResponseEntity.ok("Agence crée avec succès ! ");

    }

    // Récupération d'un resource (agence)
    @GetMapping("/{agenceId}")
    public ResponseEntity<Agence> getAgence(@PathVariable String agenceId) {
        Agence agence = this.agenceService.getAgence(agenceId);
        return ResponseEntity.ok(agence);
    }

    // Récupération de toutes les resources (agences)
    @GetMapping
    public Iterable<Agence> getAllAgences() {
        return this.agenceService.getAllAgence();
    }

    //Misé à jour d'une resource (agence)
    @PutMapping("/{agenceId}")
    public ResponseEntity<String> update(@RequestBody Agence agence, @PathVariable String agenceId) {
        // Récupération de la resource 
        Agence oldAgence = this.agenceService.getAgence(agenceId);

        if (agence != null) {
            // Mise à jour des informations
            oldAgence.setName(agence.getName());
            oldAgence.setCreated(agence.getCreated());
            oldAgence.setValid(agence.getValid());
            
            return ResponseEntity.ok("Mise à jour effectuée avec succès !");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    // Suppression d'une ressource (agence)
    @DeleteMapping("/{agenceId}")
    public ResponseEntity<String> delete(@PathVariable String agenceId) {
        this.agenceService.delete(agenceId);
        return ResponseEntity.ok("Agence supprimée avec succès ! ");
    }


}
