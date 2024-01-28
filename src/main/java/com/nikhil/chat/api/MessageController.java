//package com.nikhil.chat.api;
//
//@RestController
//@RequestMapping("/message")
//public class MessageController {
//
//    @Autowired
//    private MessageService messageService;
//
//    @PostMapping("/send")
//    public ResponseEntity<String> sendMessage(@RequestParam String sender, @RequestParam String receiver, @RequestParam String content) {
//        messageService.sendMessage(sender, receiver, content);
//        return ResponseEntity.ok("Message sent successfully");
//    }
//
//    @GetMapping("/history")
//    public ResponseEntity<List<Message>> getChatHistory(@RequestParam String user1, @RequestParam String user2) {
//        List<Message> chatHistory = messageService.getChatHistory(user1, user2);
//        return ResponseEntity.ok(chatHistory);
//    }
//}