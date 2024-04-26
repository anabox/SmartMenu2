package org.example.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.dish.Ingredient;
import org.example.entity.dish.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@DiscriminatorValue("user_waiter")
@Table(name="user_waiters")
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"orders"})
@ToString(exclude = {"orders"})
public class UserWaiter extends MenuUser{

    @OneToMany(mappedBy = "userWaiter", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();;

    public void addOrder(Order order) {
        orders.add(order);
        order.setUserWaiter(this);
    }
    public void removeOrder(Order order) {
        orders.remove(order);
        order.setUserWaiter(null);
    }
}
