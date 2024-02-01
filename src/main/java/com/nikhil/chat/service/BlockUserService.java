package com.nikhil.chat.service;

import com.nikhil.chat.core.BlockUserCore;
import com.nikhil.chat.entity.Block;
import com.nikhil.chat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockUserService {

    private final BlockUserCore blockUserCore;

    @Autowired
    public BlockUserService(BlockUserCore blockUserCore) {
        this.blockUserCore = blockUserCore;
    }

    public Block block(String user1, String user2){
        return blockUserCore.block(user1, user2);
    }
}
