package org.example.repositories.dish;

import org.example.entity.dish.Order;
import org.example.entity.dish.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
}
