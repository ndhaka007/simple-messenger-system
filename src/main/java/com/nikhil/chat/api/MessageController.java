package com.nikhil.chat.api;

import com.nikhil.chat.entity.Message;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nikhil.chat.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

   @Autowired
   private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String receiver, @RequestParam String content) {
        // Fetch sender from authentication
        String sender = getAuthenticatedUser();

        // Perform send operation
        messageService.sendMessage(sender, receiver, content);

        return ResponseEntity.ok("Message sent successfully");
    }

   @GetMapping("/")
   public ResponseEntity<List<Message>> getUnreadMessages() {
       // Fetch sender from authentication
       String requestUser = getAuthenticatedUser();
       List<Message> unreadMessages = messageService.GetUnreadMessages(requestUser);
       return ResponseEntity.ok(unreadMessages);
   }

    @GetMapping("/history")
    public ResponseEntity<List<Message>> getHistory(@RequestParam String user) {
        // Fetch sender from authentication
        String requestUser = getAuthenticatedUser();
        List<Message> history = messageService.GetHistory(requestUser, user);
        return ResponseEntity.ok(history);
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