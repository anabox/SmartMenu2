package org.example.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@NoArgsConstructor
@Data
public class MenuUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @ElementCollection
    private Set<String> roles = new HashSet<>();

    public void addRole(String role){
        roles.add(role);
    }

}
