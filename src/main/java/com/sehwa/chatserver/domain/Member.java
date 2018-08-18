package com.sehwa.chatserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "member")
@Entity
public class Member {
    public Member() {
        this.regDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(targetEntity = GroupChannel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private GroupChannel groupChannel;

    @Column(name = "first_read_id")
    private Long firstReadId;

    @Column(name = "last_read_id")
    private Long lastReadId;

    @Column(name = "is_operator")
    private Boolean isOperator;

    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
