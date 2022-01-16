package com.devsuperior.dsvomie.repositories;

import com.devsuperior.dsvomie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
