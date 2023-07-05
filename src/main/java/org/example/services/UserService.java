package org.example.services;

import org.example.entities.MyUser;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
@Service
public class UserService { private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyUser createUser(MyUser myUser) {
        return userRepository.save(myUser);
    }

    public MyUser getUserById(Long id) {  Optional<MyUser> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            // Gérer le cas où aucun utilisateur n'est trouvé pour cet identifiant
            // Vous pouvez lever une exception ou renvoyer une valeur par défaut, selon vos besoins
            // Par exemple, vous pouvez lancer une EntityNotFoundException
            throw new EntityNotFoundException("Utilisateur introuvable pour l'identifiant : " + id);
        }

    }
}
