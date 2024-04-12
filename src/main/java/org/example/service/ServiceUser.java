package org.example.service;

import org.example.credential.MenuUserDetails;
import org.example.entity.user.MenuUser;
import org.example.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceUser implements UserDetailsService {
    private UserRepository repository;

    @Autowired
    public ServiceUser(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       MenuUser user =  repository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Cannot find user"));
        Hibernate.initialize(user.getRoles());
       return new MenuUserDetails(user);
    }


}
