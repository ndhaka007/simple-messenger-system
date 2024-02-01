package com.nikhil.chat.repository;

import com.nikhil.chat.entity.Block;
import com.nikhil.chat.entity.Message;
import com.nikhil.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository  extends JpaRepository<Block, Long> {

    @Query(value = "Select * from block as b where (user1 =?1 and user2 = ?2) or (user1 =?2 and user2 = ?1) ", nativeQuery = true)
    Block GetBlockByUsers(User user1, User user2);

}
