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
@Table(name = "open_channel")
@Entity
public class OpenChannel {
    public OpenChannel() {
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

    @Column(name = "cover_file")
    private File coverFile;

    private String data;

    private List<Participant> operators = new ArrayList<>();

    @Column(name = "custom_type")
    private String customType;

    @JsonBackReference
    @OneToMany(mappedBy = "open_channel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participant> participants = new ArrayList<>();

    @Column(name = "participant_count")
    private Integer participantCount;

    @Column(name = "max_length_message")
    private Integer maxLengthMessage;

    private boolean freeze;

    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
