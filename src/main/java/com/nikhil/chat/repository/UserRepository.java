package com.nikhil.chat.repository;

import com.nikhil.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user AS u WHERE username =?1", nativeQuery = true)
    User findByUsername(String username);

    @Modifying
    @Query(value = "UPDATE User u SET u.active = true WHERE u.username =?1")
    void activateUser(String userName);

    @Modifying
    @Query(value = "UPDATE User u SET u.active = false WHERE u.username =?1")
    void deActivateUser(String userName);

    @Query(value = "SELECT * FROM user AS u WHERE active = true", nativeQuery = true)
    List<User> getActiveUsers();
}