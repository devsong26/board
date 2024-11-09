package com.board.presentation.dto.request;

import com.board.domain.DSong;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveSongRequest {

    private String title;
    private String lyrics;

    public DSong toDSong(){
        return DSong.from(this);
    }

}
