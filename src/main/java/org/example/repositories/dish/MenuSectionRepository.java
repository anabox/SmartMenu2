package org.example.repositories.dish;

import org.example.entity.dish.Menu;
import org.example.entity.dish.MenuSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuSectionRepository extends JpaRepository<MenuSection,Long> {
}
