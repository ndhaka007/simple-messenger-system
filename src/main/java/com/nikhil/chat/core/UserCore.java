package com.nikhil.chat.core;

import com.nikhil.chat.entity.User;
import com.nikhil.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserCore {
    private final UserRepository userRepository;

    @Autowired
    public UserCore(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User Create(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("User already exists");
        }

        userRepository.save(user);
        return user;
    }

    public User GetUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User Login(String userName) {
        User user = this.GetUser(userName);
        if (user == null) {
            throw new IllegalArgumentException("User doesn't exists");
        }
        userRepository.activateUser(userName);
        return user;
    }

    public User Logout(String userName) {
        User user = this.GetUser(userName);
        if (user == null) {
            throw new IllegalArgumentException("User doesn't exists");
        }
        userRepository.deActivateUser(userName);
        return user;
    }

    public List<User> GetActiveUsers() {
        return userRepository.getActiveUsers();
    }
}
