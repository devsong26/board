package com.board.domain;

import com.board.common.enums.Country;
import com.board.infrastructure.mysql.entity.Song;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
public class DSong {

    private final Long songId;
    private final String title;
    private final String lyrics;

    private final LocalDateTime regDate;
    private final LocalDateTime updDate;

    private final Long listenCnt;
    private final Long heart;

    private final boolean isDeleted;
    private final boolean isForeign;

    private final Country country;

    private DSong(Long songId, String title, String lyrics, LocalDateTime regDate, LocalDateTime updDate,
                  Long listenCnt, Long heart, boolean isDeleted, boolean isForeign, Country country){
        this.songId = songId;
        this.title = title;
        this.lyrics = lyrics;
        this.regDate = regDate;
        this.updDate = updDate;
        this.listenCnt = listenCnt;
        this.heart = heart;
        this.isDeleted = isDeleted;
        this.isForeign = isForeign;
        this.country = country;
    };

    public static DSong from(Song song){
        Objects.requireNonNull(song);

        return new DSong(song.getId(), song.getTitle(), song.getLyrics(),
                song.getRegDate(), song.getUpdDate(), song.getListenCnt(),
                song.getHeart(), song.isDeleted(), song.isForeign(), song.getCountry());
    }

    public static DSong of(String title, String lyrics){
        List.of(title, lyrics).forEach(Objects::requireNonNull);

        final LocalDateTime now = LocalDateTime.now();

        return new DSong(null, title, lyrics, now, now, 0L, 0L, false, false, null);
    }

    public static DSong of(Long songId, String title, String lyrics){
        List.of(songId, title, lyrics).forEach(Objects::requireNonNull);

        final LocalDateTime now = LocalDateTime.now();

        return new DSong(songId, title, lyrics, now, now, 0L, 0L, false, false, null);
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
