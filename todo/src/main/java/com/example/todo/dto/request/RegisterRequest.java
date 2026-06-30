package com.example.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message = "'name' is required")
    private String name;

    @NotBlank(message = "'lastName' is required")
    private String lastName;

    @NotBlank(message = "'email' is required")
    private String email;

    @NotBlank(message = "'password' is required")
    private String password;
}
