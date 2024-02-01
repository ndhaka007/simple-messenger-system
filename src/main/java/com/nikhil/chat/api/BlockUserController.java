package com.nikhil.chat.api;

import com.nikhil.chat.entity.Block;
import com.nikhil.chat.service.BlockUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/block")
public class BlockUserController {

    @Autowired
    private BlockUserService blockUserService;

    @Autowired
    public BlockUserController(BlockUserService blockUserService) {
        this.blockUserService = blockUserService;
    }

    @PostMapping("/")
    public ResponseEntity<Block> blockUser(@RequestParam String user) {
        // Fetch sender from authentication
        String requestUser = getAuthenticatedUser();
        Block block= blockUserService.block(requestUser, user);
        return ResponseEntity.ok(block);
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
