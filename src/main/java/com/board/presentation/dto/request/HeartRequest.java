package com.board.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HeartRequest {

    private Long songId;
    private boolean isHeart;

}
