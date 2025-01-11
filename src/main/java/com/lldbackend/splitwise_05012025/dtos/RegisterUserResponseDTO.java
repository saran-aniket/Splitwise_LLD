package com.lldbackend.splitwise_05012025.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDTO {
    private ResponseStatus status;
    private String message;
}
