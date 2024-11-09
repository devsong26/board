package com.board.presentation.dto.response;

import com.board.common.SongException;
import com.board.domain.DSong;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Getter
public class ListResponse {

    private final List<SongResponse> songList;

    private ListResponse(List<SongResponse> songList){
        this.songList = songList;
    }

    public static ListResponse from(List<DSong> songList){
        if(CollectionUtils.isEmpty(songList)){
            throw new SongException("빈 컬렉션으로 ListResponse 객체를 생성할 수 없습니다.");
        }

        return new ListResponse(songList.stream().map(SongResponse::from).toList());
    }

}
