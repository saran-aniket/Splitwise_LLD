package com.lldbackend.splitwise_05012025.controllers;

import com.lldbackend.splitwise_05012025.dtos.AddExpenseRequestDTO;
import com.lldbackend.splitwise_05012025.dtos.AddExpenseResponseDTO;
import com.lldbackend.splitwise_05012025.services.ExpenseService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public AddExpenseResponseDTO addExpense(AddExpenseRequestDTO addExpenseRequestDTO) {
        AddExpenseResponseDTO addExpenseResponseDTO = new AddExpenseResponseDTO();
        addExpenseResponseDTO.setExpense(expenseService.addExpense(addExpenseRequestDTO.getPaidById(), addExpenseRequestDTO.getAmount(), addExpenseRequestDTO.getDescription(), addExpenseRequestDTO.getGroupId(), addExpenseRequestDTO.getOwedByUserIds()));
        System.out.println(addExpenseResponseDTO);
        return addExpenseResponseDTO;
    }
}
