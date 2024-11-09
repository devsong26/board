package com.board.domain;

import com.board.infrastructure.mysql.entity.Song;
import com.board.presentation.dto.request.SaveSongRequest;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Getter
public class DSong {

    private final Long songId;
    private final String title;
    private final String lyrics;

    private final LocalDateTime regDate;
    private final LocalDateTime updDate;

    private final Long listenCnt;
    private final Long heart;

    private DSong(Long songId, String title, String lyrics, LocalDateTime regDate, LocalDateTime updDate, Long listenCnt, Long heart){
        this.songId = songId;
        this.title = title;
        this.lyrics = lyrics;
        this.regDate = regDate;
        this.updDate = updDate;
        this.listenCnt = listenCnt;
        this.heart = heart;
    };

    public static DSong from(Song song){
        Objects.requireNonNull(song);

        return new DSong(song.getId(), song.getTitle(), song.getLyrics(),
                song.getRegDate(), song.getUpdDate(), song.getListenCnt(),
                song.getHeart());
    }

    public static DSong of(String title, String lyrics){
        List.of(title, lyrics).forEach(Objects::requireNonNull);

        final LocalDateTime now = LocalDateTime.now();

        return new DSong(null, title, lyrics, now, now, 0L, 0L);
    }

    public static DSong of(Long songId, String title, String lyrics){
        List.of(songId, title, lyrics).forEach(Objects::requireNonNull);

        final LocalDateTime now = LocalDateTime.now();

        return new DSong(songId, title, lyrics, now, now, 0L, 0L);
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
