package org.example.repositories.user;

import org.example.entity.user.MenuUser;
import org.example.entity.user.UserWaiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWaiterRepository extends JpaRepository<UserWaiter,Long> {
}
