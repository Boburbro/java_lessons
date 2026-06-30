package com.example.todo.service;

import com.example.todo.dto.request.LoginRequest;
import com.example.todo.dto.request.RegisterRequest;
import com.example.todo.dto.response.UserResponse;

public interface UserService {

    UserResponse register(RegisterRequest request);

    String login(LoginRequest request);

    UserResponse me(String token);


}
