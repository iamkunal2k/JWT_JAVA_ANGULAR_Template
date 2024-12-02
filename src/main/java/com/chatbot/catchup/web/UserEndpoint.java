package com.chatbot.catchup.web;

import com.chatbot.catchup.domain.User;
import com.chatbot.catchup.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create-user")
    public User addUsers(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String token = userService.verify(user);
        return ResponseEntity.ok().body(token);
    }
}
