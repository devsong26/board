package com.board.presentation.dto.request;

import com.board.domain.DSong;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteSongRequest {

    private Long songId;

    public DSong toDSong(){
        return DSong.of(songId, null, null);
    }

}
