package com.sehwa.chatserver.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "message")
@Entity
public class Message {
    public Message() {
        this.regDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String message;

    @Column(name = "custom_type")
    private String customType;

    private String data;

    @Column(name = "user_id")
    private Long userId;

    private String nickname;

    @Column(name = "profile_url")
    private String profileUrl;

    @Column(name = "channel_type")
    private String channelType;

    @Column(name = "channel_url")
    private String channelUrl;

    private File file;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @Column(name = "edit_date")
    private LocalDateTime editDate;
}
