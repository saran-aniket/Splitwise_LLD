package com.lldbackend.splitwise_05012025.services;

import com.lldbackend.splitwise_05012025.dtos.AddExpenseResponseDTO;
import com.lldbackend.splitwise_05012025.models.*;
import com.lldbackend.splitwise_05012025.repositories.ExpenseRepository;
import com.lldbackend.splitwise_05012025.repositories.SplitwiseGroupRepository;
import com.lldbackend.splitwise_05012025.repositories.UserExpenseRepository;
import com.lldbackend.splitwise_05012025.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final SplitwiseGroupRepository splitwiseGroupRepository;
    private final UserExpenseRepository userExpenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository, SplitwiseGroupRepository splitwiseGroupRepository, UserExpenseRepository userExpenseRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.splitwiseGroupRepository = splitwiseGroupRepository;
        this.userExpenseRepository = userExpenseRepository;
    }

    public Expense addExpense(Long paidById, double amount, String description, Long groupId, List<Long> owedByUserIds){
        Optional<User> userOptional = userRepository.findById(paidById);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        Expense expense = new Expense();
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setCreatedBy(userOptional.get());

        if(groupId != null){
            Optional<SplitwiseGroup> splitwiseGroupOptional = splitwiseGroupRepository.findById(groupId);
            if(splitwiseGroupOptional.isEmpty()){
                throw new RuntimeException("Group not found");
            }
            expense.setGroup(splitwiseGroupOptional.get());
        }
        expenseRepository.save(expense);

        int participantsCount = owedByUserIds.size() + 1;
        double share = amount/participantsCount;

        UserExpense paidByUserExpense = new UserExpense();
        paidByUserExpense.setExpense(expense);
        paidByUserExpense.setUser(userOptional.get());
        paidByUserExpense.setAmount(share*(participantsCount-1));
        paidByUserExpense.setUserExpenseType(UserExpenseType.LENDER);
        userExpenseRepository.save(paidByUserExpense);

        for(Long owedById : owedByUserIds){
            Optional<User> owedByUserOptional = userRepository.findById(owedById);
            if(owedByUserOptional.isEmpty()){
                throw new RuntimeException("User not found");
            }
            UserExpense userExpense = new UserExpense();
            userExpense.setExpense(expense);
            userExpense.setUser(owedByUserOptional.get());
            userExpense.setAmount((-1)*share);
            userExpense.setUserExpenseType(UserExpenseType.BORROWER);
            userExpenseRepository.save(userExpense);
        }

        return expense;
    }
}
