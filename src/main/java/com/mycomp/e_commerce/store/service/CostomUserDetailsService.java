package com.mycomp.e_commerce.store.service;

import com.mycomp.e_commerce.store.model.User;
import com.mycomp.e_commerce.store.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Component
public class CostomUserDetailsService implements UserDetailsService {

    private  final UserRepository userRepository;

    public CostomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(Objects.isNull(user)){
            System.out.println("User not available");
            throw new UsernameNotFoundException("User not found");
        }
        return new CostomUserDetails(user);
    }
}

