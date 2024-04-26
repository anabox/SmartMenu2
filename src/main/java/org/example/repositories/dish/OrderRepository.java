package org.example.repositories.dish;

import org.example.entity.dish.Dish;
import org.example.entity.dish.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
