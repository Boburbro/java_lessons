package com.example.todo.service.impl;

import com.example.todo.config.JwtUtil;
import com.example.todo.dto.request.TodoCreateRequest;
import com.example.todo.dto.request.TodoStatusRequest;
import com.example.todo.dto.response.TodoResponse;
import com.example.todo.entity.Status;
import com.example.todo.entity.Todo;
import com.example.todo.entity.User;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Override
    public List<TodoResponse> getAllTodo(String token, int page, int size) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Missing or invalid token"
            );
        }
        String jwt = token.replace("Bearer ", "");
        String email = JwtUtil.extractEmail(jwt);

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User not found"
        ));

        int safePage = Math.max(page, 0);
        int safeSize = (size <= 0 || size > 100) ? 20 : size;

        Pageable pageable = PageRequest.of(safePage, safeSize);
        return todoRepository.findByUser(user, pageable)
                .map(this::mapToResponse)
                .getContent();
    }

    @Override
    public TodoResponse getTodoById(String token, Long id){
        if (token == null || !token.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Missing or invalid token"
            );
        }
        String jwt = token.replace("Bearer ", "");
        String email = JwtUtil.extractEmail(jwt);

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User not found"
        ));

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Todo not found"
                ));

        if (!todo.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "You don't have permission to delete this todo"
            );
        }

        return mapToResponse(todo);
    }

    @Override
    public TodoResponse createTodo(String token, TodoCreateRequest request) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Missing or invalid token"
            );
        }
        String jwt = token.replace("Bearer ", "");
        String email = JwtUtil.extractEmail(jwt);

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User not found"
        ));

        Todo todo = Todo.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .priority(request.getPriority())
                .status(Status.TODO)
                .dueDate(request.getDueDate())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .user(user)
                .build();

        Todo savedTodo = todoRepository.save(todo);

        return mapToResponse(savedTodo);
    }

    @Override
    public TodoResponse deleteTodo(String token, Long id) {

        if (token == null || !token.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Missing or invalid token"
            );
        }
        String jwt = token.replace("Bearer ", "");
        String email = JwtUtil.extractEmail(jwt);

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User not found"
        ));

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Todo not found"
                ));

        if (!todo.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "You don't have permission to delete this todo"
            );
        }

        todoRepository.delete(todo);

        return mapToResponse(todo);
    }

    @Override
    public TodoResponse updateStatus(String token, Long id, TodoStatusRequest request){
        if (token == null || !token.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Missing or invalid token"
            );
        }
        String jwt = token.replace("Bearer ", "");
        String email = JwtUtil.extractEmail(jwt);

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User not found"
        ));

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Todo not found"
                ));

        if (!todo.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "You don't have permission to update this todo"
            );
        }

        todo.setStatus(request.getStatus());
        todo.setUpdatedAt(LocalDateTime.now());
        Todo updatedTodo = todoRepository.save(todo);

        return mapToResponse(updatedTodo);
    }


    private TodoResponse mapToResponse(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .priority(todo.getPriority())
                .status(todo.getStatus())
                .dueDate(todo.getDueDate())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }

}
