package org.example.service;

import org.example.credential.MenuUserDetails;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser implements UserDetailsService {
    private UserRepository repository;

    @Autowired
    public ServiceUser(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MenuUserDetails(repository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Cannot find user")
        ));

    }


}
