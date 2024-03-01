package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailsService service;

    @Autowired
    public SecurityConfig(UserDetailsService service) {
        this.service = service;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(service);

        return new ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http, AuthenticationManager manager) throws Exception {
        return http
//                .csrf().disable()
                .authorizeHttpRequests(auth -> auth.requestMatchers("/login").permitAll()
                        .requestMatchers("/menu/", "/menu").hasRole("ADMIN")
                        .anyRequest().hasAnyRole("USER","ADMIN"))
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
                .authenticationManager(manager)
                .build();
    }
}
