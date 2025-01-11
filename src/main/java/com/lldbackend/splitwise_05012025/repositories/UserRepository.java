package com.lldbackend.splitwise_05012025.repositories;

import com.lldbackend.splitwise_05012025.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
