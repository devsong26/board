package com.board.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Setter
@Getter
public class ListRequest {

    @NonNull
    private Long page;
    @NonNull
    private Long size;

    private String title;
    private String lyrics;

    @NonNull
    private LocalDateTime startAt;
    @NonNull
    private LocalDateTime endAt;

    private Boolean isDeleted;

    public Long getPage(){
        return page - 1;
    }

}
