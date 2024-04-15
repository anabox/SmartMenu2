package org.example.entity.user;

import jakarta.persistence.*;
import org.example.entity.dish.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserWaiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @ElementCollection
    private Set<String> roles = new HashSet<>();
   //запуталась в связке Официант-заказ
    //у одного заказа может быть только один официант,
   // но у одного официанта может быть много заказов
    private Set<Order> orders;
}
