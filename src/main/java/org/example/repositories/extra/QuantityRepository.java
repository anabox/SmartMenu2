package org.example.repositories.extra;

import org.example.entity.extra.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityRepository extends JpaRepository<Quantity,Long> {
}
