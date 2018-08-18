package com.sehwa.chatserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "group_channel")
@Entity
public class GroupChannel {
    public GroupChannel() {
        this.regDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "channel_url")
    private String channelUrl;

    @Column(name = "cover_url")
    private String coverUrl;

    @Column(name = "custom_type")
    private String customType;

    @Column(name = "cover_file")
    private File coverFile;

    private String data;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(name = "is_ephemeral")
    private boolean isEphemeral;

    @Column(name = "is_distinct")
    private boolean isDistinct;

    private List<Member> operators = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "group_channel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();

    @Column(name = "member_count")
    private Integer memberCount;

    @Column(name = "max_length_message")
    private Integer maxLengthMessage;

    private boolean freeze;

    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
