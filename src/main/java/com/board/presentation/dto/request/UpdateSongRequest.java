package com.board.presentation.dto.request;

import com.board.domain.DSong;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateSongRequest {

    private Long songId;
    private String title;
    private String content;

    public DSong toDSong(){
        return DSong.of(songId, title, content);
    }

}
