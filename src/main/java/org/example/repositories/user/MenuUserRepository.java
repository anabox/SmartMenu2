package org.example.repositories.user;

import org.example.entity.user.MenuUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuUserRepository extends JpaRepository<MenuUser,Long> {
}
