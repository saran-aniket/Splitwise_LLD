package com.lldbackend.splitwise_05012025.commands;

import com.lldbackend.splitwise_05012025.controllers.ExpenseController;
import com.lldbackend.splitwise_05012025.dtos.AddExpenseRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class AddExpenseCommand implements Command {
    private final ExpenseController expenseController;

    public AddExpenseCommand(ExpenseController expenseController) {
        this.expenseController = expenseController;
    }

    @Override
    public boolean validate(String inputCommand) {
        List<String> commandParts = List.of(inputCommand.split(" "));
        return commandParts.get(1).equals("Expense");
    }

    @Override
    public void execute(String inputCommand) {
        System.out.println("Adding expense");
        //u1 Expense u2 u3 u4 iPay 1000 Equal Desc Last night dinner
        int i = 0;
        List<String> commandParts = List.of(inputCommand.split(" "));
        AddExpenseRequestDTO addExpenseRequestDTO = new AddExpenseRequestDTO();
        addExpenseRequestDTO.setPaidById(Long.parseLong(commandParts.get(i++)));
        i++;
        addExpenseRequestDTO.setOwedByUserIds(new ArrayList<>());
        while(!commandParts.get(i).equals("iPay")){
            addExpenseRequestDTO.getOwedByUserIds().add(Long.parseLong(commandParts.get(i++)));
        }
        i++;
        addExpenseRequestDTO.setAmount(Double.parseDouble(commandParts.get(i++)));
        i+=2;
        String desc = "";
        while(i < commandParts.size()){
            desc += commandParts.get(i++) + " ";
        }
        addExpenseRequestDTO.setDescription(desc);
        expenseController.addExpense(addExpenseRequestDTO);

    }
}
