package com.board.presentation.dto.response;

import com.board.domain.DSong;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SongResponse {

    private final String title;
    private final String lyrics;

    private final Long listenCnt;
    private final Long heart;

    private SongResponse(DSong dSong){
        this.title = dSong.getTitle();
        this.lyrics = dSong.getLyrics();

        this.listenCnt = dSong.getListenCnt();
        this.heart = dSong.getHeart();
    }

    public static SongResponse from(DSong dSong){
        Objects.requireNonNull(dSong);

        return new SongResponse(dSong);
    }

}
