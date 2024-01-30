package com.nikhil.chat.service;

import com.nikhil.chat.entity.Message;
import com.nikhil.chat.core.MessageCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageCore messageCore;

    @Autowired
    public MessageService(MessageCore messageCore) {
        this.messageCore = messageCore;
    }

    public void sendMessage(String sender, String receiver, String content){
        messageCore.sendMessage(sender, receiver, content);
    }

    public List<Message> GetUnreadMessages(String requestUser){
        return messageCore.GetUnreadMessages(requestUser);
    }

    public List<Message> GetHistory(String requestUser, String user){
        return messageCore.GetHistory(requestUser, user);
    }
}