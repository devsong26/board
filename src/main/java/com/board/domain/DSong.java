package com.board.domain;

import com.board.infrastructure.mysql.entity.Song;
import com.board.presentation.dto.request.SaveSongRequest;
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

    private DSong(String title, String lyrics, LocalDateTime regDate, LocalDateTime updDate, Long listenCnt, Long heart){
        this.title = title;
        this.lyrics = lyrics;
        this.regDate = regDate;
        this.updDate = updDate;
        this.listenCnt = listenCnt;
        this.heart = heart;
    };

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

    public static DSong from(SaveSongRequest req){
        Objects.requireNonNull(req);

        final LocalDateTime now = LocalDateTime.now();

        return new DSong(req.getTitle(), req.getLyrics(), now, now, 0L, 0L);
    }

    public Song toEntity(){
        final Song song = new Song();

        song.setTitle(this.title);
        song.setLyrics(this.lyrics);
        song.setRegDate(this.regDate);
        song.setUpdDate(this.updDate);
        song.setListenCnt(this.listenCnt);
        song.setHeart(this.heart);

        return song;
    }

}
