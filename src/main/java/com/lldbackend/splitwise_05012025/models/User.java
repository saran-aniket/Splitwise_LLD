package com.lldbackend.splitwise_05012025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "splitwise_users")
public class User extends BaseModel{
    private String username;
    private String password;
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<UserExpense> userExpenses;
}
