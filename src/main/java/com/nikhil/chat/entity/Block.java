package com.nikhil.chat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "block")
@NoArgsConstructor
public class Block extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Long id;

    @OneToOne
    @Column(name = "user1",unique = true, nullable = false)
    private User user1;

    @OneToOne
    @Column(name = "user2",nullable = false)
    private User user2;
}
