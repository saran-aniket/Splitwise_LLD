package com.lldbackend.splitwise_05012025;

import com.lldbackend.splitwise_05012025.commands.AddExpenseCommand;
import com.lldbackend.splitwise_05012025.commands.CommandExecutor;
import com.lldbackend.splitwise_05012025.commands.RegisterUserCommand;
import com.lldbackend.splitwise_05012025.controllers.ExpenseController;
import com.lldbackend.splitwise_05012025.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Splitwise05012025Application implements CommandLineRunner {
    @Autowired
    private CommandExecutor commandExecutor;

    @Autowired
    private UserController userController;

    @Autowired
    private ExpenseController expenseController;

    public static void main(String[] args) {
        SpringApplication.run(Splitwise05012025Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from Splitwise");
        commandExecutor.addCommand(new RegisterUserCommand(userController));
        commandExecutor.addCommand(new AddExpenseCommand(expenseController));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command:");
            String inputCommand = scanner.nextLine();
            commandExecutor.executeCommand(inputCommand);
            System.out.println("Command entered: " + inputCommand);
        }
    }
}
