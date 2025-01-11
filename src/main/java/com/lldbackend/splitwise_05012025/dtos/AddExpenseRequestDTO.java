package com.lldbackend.splitwise_05012025.dtos;

import com.lldbackend.splitwise_05012025.models.SplitwiseGroup;
import com.lldbackend.splitwise_05012025.models.User;
import com.lldbackend.splitwise_05012025.models.UserExpense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddExpenseRequestDTO {
    private Long paidById;
    private double amount;
    private String description;
    private Long groupId;
    private List<Long> owedByUserIds;
}
