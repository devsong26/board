package com.board.infrastructure.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Song {

    @Id
    private Long id;

    private String title;
    private String lyrics;

    private LocalDateTime regDate;
    private LocalDateTime updDate;

    private Long listenCnt;
    private Long heart;

    @Version
    private Long version;

    private boolean isDeleted;

}
