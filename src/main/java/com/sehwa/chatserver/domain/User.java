package com.sehwa.chatserver.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "user")
@Entity
public class User implements Serializable {
    public User() {
        this.regDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    private String nickname;

    @Column(name = "profile_url")
    private String profileUrl;

    @Column(name = "profile_file")
    private File profileFile;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_online")
    private boolean isOnline;

    @Column(name = "last_seen_at")
    private LocalDateTime lastSeenAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participant> participants = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();

    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
