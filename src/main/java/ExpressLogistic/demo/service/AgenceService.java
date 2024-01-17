package ExpressLogistic.demo.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ExpressLogistic.demo.domaine.Agence;
import ExpressLogistic.demo.repository.AgenceRepository;

@Service
public class AgenceService {
    
    // Propriété reçevant l'injection du repository
    private AgenceRepository agenceRepository; 

    public AgenceService( AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    // Création d'un agence 
    public Agence create(Agence agence) {
        return this.agenceRepository.save(agence);
    }

    // Récupération d'un resource (agence)
    public Agence getAgence(String Id) {
        Optional<Agence> agence = this.agenceRepository.findById(Id);

        if (agence.isPresent()) {
            return agence.get();
        }
        return null;
    }

    // Récupération de toutes les resources(agences)
    public Iterable<Agence> getAllAgence() {
        return this.agenceRepository.findAll();
    }

    
    // Mise à jour d'une resource 

    // Suppression d'une ressource 
    public ResponseEntity<Void> delete(String Id) {
        this.agenceRepository.deleteById(Id);
        return ResponseEntity.noContent().build();
    }
}
