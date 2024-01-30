package com.nikhil.chat.api;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.nikhil.chat.entity.User;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.nikhil.chat.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path ="/register", produces = {APPLICATION_JSON})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "SUCCESS"),
                    @ApiResponse(code = 400, message = "VALIDATION_EXCEPTION"),
            })
    public ResponseEntity<User> registerUser(@RequestBody User requestBody) {
        if (requestBody.getUsername() == null || requestBody.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            User user = userService.registerUser(requestBody);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            // Handle any exceptions that might occur during user registration
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam String userName) {;
        User history = userService.Login(userName);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/logout")
    public ResponseEntity<User> logout() {
        // Fetch sender from authentication
        String userName = getAuthenticatedUser();
        User user = userService.Logout(userName);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.GetUsers();
        return ResponseEntity.ok(users);
    }


    private String getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        // You can handle the case where there's no authenticated user (e.g., throw an exception or return a default value)
        return "default_sender";
    }
}
