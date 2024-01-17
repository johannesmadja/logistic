package ExpressLogistic.demo.service;


import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ExpressLogistic.demo.domaine.User;
import ExpressLogistic.demo.repository.UserRepository;

@Service
public class UserService {
    
    // propriété repository 
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Création d'un utilisateur 
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    // Création de plusieurs utilisateur 
    public Iterable<User> createManyUser(Iterable<User> users) {
        return this.userRepository.saveAll(users);
    }

    // Récupération d'un utilisateur par son id 
    public User getUser(String id) {
        Optional<User> user =  this.userRepository.findById(id);

        if (user.isPresent()) {
            return user.get(); 
        } 
        return null;
    }

    // Récupération de tous les utilisateurs 
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    //Mise à jour d'information utilisteur 
    public User update(String id) {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isPresent()) {
            return user.get(); 
        } 
        return null;
    }

    // Suppression d'un utilisateur 
    public ResponseEntity<Void> delete(String id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
