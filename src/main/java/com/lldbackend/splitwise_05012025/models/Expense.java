package com.lldbackend.splitwise_05012025.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel{
    private String description;
    private Double amount;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private SplitwiseGroup group;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> userExpenses;
    @Enumerated(EnumType.STRING)
    ExpenseType expenseType;
}
