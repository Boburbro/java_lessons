package com.example.todo.controller.v1;

import com.example.todo.dto.request.TodoCreateRequest;
import com.example.todo.dto.request.TodoStatusRequest;
import com.example.todo.dto.response.TodoResponse;
import com.example.todo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoResponse> getAllTodo(@RequestHeader("Authorization") String token, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return todoService.getAllTodo(token, page, size);
    }

    @GetMapping("/{id}")
    public TodoResponse getTodoById(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return todoService.getTodoById(token, id);
    }

    @PatchMapping("/{id}/status")
    public TodoResponse updateStatus(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody TodoStatusRequest request
    ) {
        return todoService.updateStatus(token, id, request);
    }

    @PostMapping
    public TodoResponse createTodo(@RequestHeader("Authorization") String token, @Valid @RequestBody TodoCreateRequest request) {
        return todoService.createTodo(token, request);
    }

    @DeleteMapping("/{id}")
    public TodoResponse deleteTodo(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return todoService.deleteTodo(token, id);
    }
}
