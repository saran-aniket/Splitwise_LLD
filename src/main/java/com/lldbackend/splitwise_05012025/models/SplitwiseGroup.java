package com.lldbackend.splitwise_05012025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "splitwise_groups")
public class SplitwiseGroup extends BaseModel{
    String groupName;
    String groupDescription;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> users;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}
