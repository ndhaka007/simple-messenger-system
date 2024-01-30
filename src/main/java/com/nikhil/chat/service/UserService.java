package com.nikhil.chat.service;

import com.nikhil.chat.entity.User;
import com.nikhil.chat.core.UserCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final UserCore userCore;

    @Autowired
    public UserService(UserCore userCore) {
        this.userCore = userCore;
    }


    public User registerUser(User user) {
        userCore.Create(user);
        return user;
    }

    public User Login(String userName) {
        return userCore.Login(userName);
    }

    public User Logout(String userName) {
        return userCore.Logout(userName);
    }

    public List<User> GetUsers() {
        return userCore.GetActiveUsers();
    }
}