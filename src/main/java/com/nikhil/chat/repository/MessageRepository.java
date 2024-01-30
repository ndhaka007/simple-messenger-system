package com.nikhil.chat.repository;

import com.nikhil.chat.entity.Message;
import com.nikhil.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT * FROM messages AS m WHERE receiver_id =?1 AND read_at = NULL", nativeQuery = true)
    List<Message> GetUnreadMessagesForUser(User user);

    @Query(value = "SELECT * FROM messages AS m WHERE (receiver_id =?1 AND sender_id =?2) or (receiver_id =?2 AND sender_id =?1)", nativeQuery = true)
    List<Message> GetHistoryByReceiverAndSender(User user1, User user2);
}