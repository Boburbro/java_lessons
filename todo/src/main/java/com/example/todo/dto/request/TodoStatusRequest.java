package com.example.todo.dto.request;

import com.example.todo.entity.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoStatusRequest {

    @NotBlank(message = "Title is required")
    private Status status;

}
