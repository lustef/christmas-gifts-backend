package com.lustef.christmas.repository;

import com.lustef.christmas.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    UserAccount findByUsername(String username);
    UserAccount findByUsernameAndPassword (String username, String password);
}
