package org.example.repositories.extra;

import org.example.entity.dish.Dish;
import org.example.entity.extra.StopList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopListRepository extends JpaRepository<StopList,Long> {
}
