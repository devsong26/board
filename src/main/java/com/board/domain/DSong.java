package com.board.domain;

import com.board.infrastructure.mysql.entity.Song;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class DSong {

    private final String title;
    private final String lyrics;

    private final LocalDateTime regDate;
    private final LocalDateTime updDate;

    private final Long listenCnt;
    private final Long heart;

    private DSong(Song song){
        this.title = song.getTitle();
        this.lyrics = song.getLyrics();

        this.regDate = song.getRegDate();
        this.updDate = song.getUpdDate();

        this.listenCnt = song.getListenCnt();
        this.heart = song.getHeart();
    }

    public static DSong from(Song song){
        Objects.requireNonNull(song);

        return new DSong(song);
    }

}
