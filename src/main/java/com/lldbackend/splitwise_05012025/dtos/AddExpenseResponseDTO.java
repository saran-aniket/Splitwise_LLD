package com.lldbackend.splitwise_05012025.dtos;

import com.lldbackend.splitwise_05012025.models.Expense;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddExpenseResponseDTO {
    private Expense expense;
    private String message;
    private ResponseStatus status;

    @Override
    public String toString() {
        return "AddExpenseResponseDTO{" +
                "expense=" + expense +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
