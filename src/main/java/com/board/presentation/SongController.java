package com.board.presentation;

import com.board.application.service.SongService;
import com.board.presentation.dto.response.Top100Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.board.common.Const.API_URI;

@RequestMapping(value = API_URI + "/song")
@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/top100")
    public Top100Response getTop100Song() {
        return Top100Response.from(songService.getTop100());
    }

}
