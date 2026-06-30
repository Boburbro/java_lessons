package com.example.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    @NotBlank(message = "'email' is required")
    private String email;

    @NotBlank(message = "'password' is required")
    private String password;
}
