package com.nikhil.chat.core;

import com.nikhil.chat.entity.Message;
import com.nikhil.chat.entity.User;
import com.nikhil.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageCore {
    private final MessageRepository messageRepository;
    private final UserCore userCore;

    @Autowired
    public MessageCore(MessageRepository messageRepository, UserCore userCore ) {
        this.userCore = userCore;
        this.messageRepository = messageRepository;
    }

    public void sendMessage(String sender, String receiver, String content) {
        // Assuming currentTimestamp is the current timestamp
        long currentTimestamp = System.currentTimeMillis();

        User senderUser = userCore.GetUser(sender);
        User receiverUser = userCore.GetUser(receiver);

        Message message = new Message();
        message.setText(content);
        message.setSender(senderUser);
        message.setReceiver(receiverUser);
        message.setSentAt(currentTimestamp);

        messageRepository.save(message);
    }

    public List<Message> GetUnreadMessages(String requestUser){
        User senderUser = userCore.GetUser(requestUser);
        return messageRepository.GetUnreadMessagesForUser(senderUser);
    }

    public List<Message> GetHistory(String requestUser, String user){
        User user1 = userCore.GetUser(requestUser);
        User user2 = userCore.GetUser(user);
        return messageRepository.GetHistoryByReceiverAndSender(user1, user2);
    }

}
