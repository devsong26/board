package com.board.presentation.dto.request;

import com.board.common.Country;
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

    private Boolean isForeign;

    private Country country;

    public Long getPage(){
        return page - 1;
    }

}
