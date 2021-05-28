package com.florian.gestfact.security.service;

import com.florian.gestfact.security.model.User;
import com.florian.gestfact.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public Optional <User> getUser(final Long id){
        return userRepository.findById(id);
    }
}
