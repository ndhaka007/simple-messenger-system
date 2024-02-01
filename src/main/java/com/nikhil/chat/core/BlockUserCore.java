package com.nikhil.chat.core;

import com.nikhil.chat.entity.Block;
import com.nikhil.chat.entity.User;
import com.nikhil.chat.repository.BlockRepository;
import com.nikhil.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockUserCore {

    private final BlockRepository blockRepository;
    private final UserCore userCore;

    @Autowired
    public BlockUserCore(BlockRepository blockRepository, UserCore userCore ) {
        this.userCore = userCore;
        this.blockRepository = blockRepository;
    }

    public Block block(String userName1, String userName2){
       User user1 = userCore.GetUser(userName1);
       User user2 = userCore.GetUser(userName2);

       Block block = new Block();
       block.setUser1(user1);
       block.setUser2(user2);

       blockRepository.save(block);
       return block;
    }


    public boolean IsUserBlocked(String userName1, String userName2) {
        User user1 = userCore.GetUser(userName1);
        User user2 = userCore.GetUser(userName2);

        Block block = blockRepository.GetBlockByUsers(user1, user2);
        return block != null;
    }
}
