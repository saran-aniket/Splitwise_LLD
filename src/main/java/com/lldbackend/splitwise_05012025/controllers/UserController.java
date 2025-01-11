package com.lldbackend.splitwise_05012025.controllers;

import com.lldbackend.splitwise_05012025.dtos.RegisterUserRequestDTO;
import com.lldbackend.splitwise_05012025.dtos.RegisterUserResponseDTO;
import com.lldbackend.splitwise_05012025.dtos.ResponseStatus;
import com.lldbackend.splitwise_05012025.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDTO createUser(RegisterUserRequestDTO registerUserRequestDTO) {
        RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO();
        userService.createUser(registerUserRequestDTO.getUsername(), registerUserRequestDTO.getPassword(), registerUserRequestDTO.getPhoneNumber());
        registerUserResponseDTO.setStatus(ResponseStatus.SUCCESS);
        return registerUserResponseDTO;
    }

}
