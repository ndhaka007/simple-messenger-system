package com.nikhil.chat.api;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.nikhil.chat.entity.User;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nikhil.chat.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.registerUser(username, password);
        return ResponseEntity.ok("User registered successfully");
    }

//    @GetMapping("/{username}")
//    public ResponseEntity<User> getUser(@PathVariable String username) {
//        User user = userService.getUser(username);
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping("/{username}/friends")
//    public ResponseEntity<List<String>> getFriends(@PathVariable String username) {
//        List<String> friends = userService.getFriends(username);
//        return ResponseEntity.ok(friends);
//    }
//
//    @PostMapping("/{username}/add-friend")
//    public ResponseEntity<String> addFriend(@PathVariable String username, @RequestParam String friendUsername) {
//        userService.addFriend(username, friendUsername);
//        return ResponseEntity.ok("Friend added successfully");
//    }
}
