package com.lldbackend.splitwise_05012025.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {
    private String username;
    private String password;
    private String phoneNumber;
}
