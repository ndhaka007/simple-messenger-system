package com.nikhil.chat.service;

import com.nikhil.chat.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private Map<String, User> users = new ConcurrentHashMap<>();


    public User registerUser(String username, String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        users.put(username, newUser);
        return newUser;
    }


//    public User getUser(String username) {
//        return users.get(username);
//    }
//
//
//    public List<String> getFriends(String username) {
//        User user = users.get(username);
//        return user != null ? user.getFriends() : Collections.emptyList();
//    }
//
//
//    public void addFriend(String username, String friendUsername) {
//        User user = users.get(username);
//        if (user != null) {
//            user.getFriends().add(friendUsername);
//        }
//    }
}