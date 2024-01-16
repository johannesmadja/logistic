package ExpressLogistic.demo.service;


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

    // Récupération de tous les utilisateurs 
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
