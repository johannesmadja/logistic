package ExpressLogistic.demo.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ExpressLogistic.demo.domaine.Agence;
import ExpressLogistic.demo.domaine.User;
import ExpressLogistic.demo.service.AgenceService;
import ExpressLogistic.demo.service.UserService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserResource {
    
    // Propriété du service 
    private final UserService userService;
    // propritété du service agence 
    private final AgenceService agenceService;

    // Contructeur 
    public UserResource(UserService userService, AgenceService agenceService) {
        this.userService = userService;
        this.agenceService = agenceService;
    }

    // Récupération d'un utilisateur 
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = this.userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // Récupération de tous les utilisateurs 
    @GetMapping
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> users = this.userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    // Création d'un utilisateur 
    @PostMapping("/create")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        this.userService.createUser(user);
        
        // return ResponseEntity.created(null);
        return ResponseEntity.ok("Utilisateur ajouté ! ");
    }

    // Création de plusieurs utilisateurs 
    @PostMapping("/creates")
    public ResponseEntity<String> saveAllUsers(@RequestBody Iterable<User> users) {
        this.userService.createManyUser(users);

        return ResponseEntity.ok("Les utilisateurs ont été créée !");
    }

    

    // Mise à jour d'information utilisateur 
    @PutMapping("/{requestId}")
    public ResponseEntity<String> updateUser(@PathVariable String requestId, @RequestBody User user) {
        User userUpdated = this.userService.update(requestId);
        if (userUpdated != null) {
            userUpdated.setName(user.getName());
            userUpdated.setLastName(user.getLastName());
            userUpdated.setMail(user.getMail());
            userUpdated.setPhoneNumber(user.getPhoneNumber());
            userUpdated.setRole(user.getRole());
            userUpdated.setAgences(user.getAgences());
            this.userService.createUser(userUpdated);
            
            return ResponseEntity.ok("Mise à jour éffecturé avec succès !");     
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Suppression d'un utilisateur 
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        // Rechercher le user
        User user = this.userService.getUser(userId);
        if (user != null) {
            this.userService.delete(userId);
            return ResponseEntity.ok("Utilisateur supprimé avec succès !");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Affectation d'un utilisateur à une agence 
    @PutMapping("/setAgence/{userId}")
    public ResponseEntity<String> setUserToAgence(@PathVariable String userId, @RequestBody Agence agence) {
        // Récupération de le l'utilisateur 
        User user = this.userService.getUser(userId);
        
        // Récupération de l'agence 
        Agence agences = this.agenceService.getAgence(agence.getId());

        if (user != null && agences != null) {
            // System.out.print(agences.getId());
            // System.out.print(agences.getName());
            // System.out.print(agences.getValid());
            user.setAgences(agences);
            this.userService.createUser(user);
            return ResponseEntity.ok("Utilisateur affecté à une agence ! ");
        }
        return ResponseEntity.notFound().build();
    }
    

}
