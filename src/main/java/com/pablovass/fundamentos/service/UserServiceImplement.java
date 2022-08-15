package com.pablovass.fundamentos.service;
import com.pablovass.fundamentos.entity.User;
import com.pablovass.fundamentos.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImplement implements UserService{
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImplement.class);
    private static final String MESSAGE_USER_NOT_FOUND = "Ha ocurrido un error buscando el usuario por email";
    private UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
//        Optional<User> optionalUser = userRepository.findMyUserByEmail(email);
//        if (optionalUser.isPresent()) {
//            return optionalUser.get();
//        }
    //    return userRepository.findMyUserByEmail(email).orElseThrow(() -> new RuntimeException(MESSAGE_USER_NOT_FOUND));
//        throw new RuntimeException("Ha ocurrido un error buscando el usuario por email");
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.findByNameContaining(name);
    }


    @Transactional
    public void save(List<User> users) {
        users.stream()
                .peek(user -> logger.info("Insert: " + user))
                .forEach(user -> userRepository.save(user));
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}

