package com.lldbackend.splitwise_05012025.commands;

import com.lldbackend.splitwise_05012025.controllers.UserController;
import com.lldbackend.splitwise_05012025.dtos.RegisterUserRequestDTO;
import com.lldbackend.splitwise_05012025.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static com.lldbackend.splitwise_05012025.commands.CommandConstants.REGISTER_USER;

public class RegisterUserCommand implements Command {
    private final UserController userController;

    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean validate(String inputCommand) {
        List<String> commandParts = List.of(inputCommand.split(" "));
        return commandParts.size() == 4 && commandParts.get(0).equals(REGISTER_USER);
    }

    @Override
    public void execute(String inputCommand) {
        //Register vinsmokesanji 003 namisswwaann
        System.out.println("Registering user");
        List<String> commandParts = List.of(inputCommand.split(" "));
        RegisterUserRequestDTO registerUserRequestDTO = new RegisterUserRequestDTO();
        registerUserRequestDTO.setUsername(commandParts.get(1));
        registerUserRequestDTO.setPhoneNumber(commandParts.get(2));
        registerUserRequestDTO.setPassword(commandParts.get(3));
        userController.createUser(registerUserRequestDTO);
    }
}
