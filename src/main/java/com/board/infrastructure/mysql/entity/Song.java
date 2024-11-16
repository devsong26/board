package com.board.infrastructure.mysql.entity;

import com.board.common.enums.Country;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Cacheable
@Data
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

    private boolean isForeign;

    @Column(columnDefinition = "VARCHAR(32)")
    private Country country;

}
