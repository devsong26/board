package com.board.presentation.dto.response;

import com.board.common.exception.SongException;
import com.board.domain.DSong;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Getter
public class Top100Response {

    private final List<SongResponse> songResponseList;

    private Top100Response(List<SongResponse> songResponseList){
        this.songResponseList = songResponseList;
    }

    public static Top100Response from(final List<DSong> dSongList){
        if(CollectionUtils.isEmpty(dSongList)){
            throw new SongException("빈 컬렉션으로 Top100Response를 생성할 수 없습니다.");
        }

        final List<SongResponse> songResponseList =
                dSongList.stream().map(SongResponse::from)
                        .toList();

        return new Top100Response(songResponseList);
    }

}
