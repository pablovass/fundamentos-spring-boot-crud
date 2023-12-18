package com.pablovass.service;

import com.pablovass.persistence.entity.UserEntity;
import com.pablovass.persistence.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** lo mas convieniente, lo que tenga que ver con usuarios y permisos manejarlo desde un app diferente, a modo ilustrativo lo dejo aca */
@Service
public class UserSecurityService implements UserDetailsService {
    private  final UserRepository userRepository;

    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=this.userRepository.findById(username)
                .orElseThrow(()->new UsernameNotFoundException("user "+ username+" not found"));

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles("ADMIN")
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }
}
