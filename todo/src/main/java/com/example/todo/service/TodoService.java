package com.example.todo.service;

import com.example.todo.dto.request.TodoCreateRequest;
import com.example.todo.dto.request.TodoStatusRequest;
import com.example.todo.dto.response.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getAllTodo(String token, int page, int size);
    TodoResponse getTodoById(String token, Long id);
    TodoResponse createTodo(String token, TodoCreateRequest request);
    TodoResponse deleteTodo(String token, Long id);
    TodoResponse updateStatus(String token, Long id, TodoStatusRequest request);
}
