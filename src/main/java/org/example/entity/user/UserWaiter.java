package org.example.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.dish.Ingredient;
import org.example.entity.dish.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name="userWaiters")
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"roles"})
@ToString(exclude = {"roles"})
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
   @OneToMany(mappedBy = "userWaiter", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
        order.setUserWaiter(this);
    }
    public void removeOrder(Order order) {
        orders.remove(order);
        order.setUserWaiter(null);
    }
}
