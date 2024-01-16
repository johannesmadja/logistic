package ExpressLogistic.demo.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExpressLogistic.demo.domaine.User;
import ExpressLogistic.demo.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
    
    // Propriété du service 
    private final UserService userService;

    // Contructeur 
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    // Récupération de tous les utilisateurs 
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> users = this.userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    // Création d'un utilisateur 
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        this.userService.createUser(user);
        
        return ResponseEntity.ok("Utilisateur ajouté ! ");
    }
    

}
