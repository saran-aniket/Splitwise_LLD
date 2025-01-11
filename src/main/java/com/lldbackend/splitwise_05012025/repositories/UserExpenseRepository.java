package com.lldbackend.splitwise_05012025.repositories;

import com.lldbackend.splitwise_05012025.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
}
