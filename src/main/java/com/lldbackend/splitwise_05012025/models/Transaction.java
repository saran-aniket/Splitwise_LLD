package com.lldbackend.splitwise_05012025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_transactions")
public class Transaction extends BaseModel{
    private Double amount;
    @ManyToOne
    private User paidBy;
    @ManyToOne
    private User paidTo;
}
