package com.board.presentation;

import com.board.application.service.SongService;
import com.board.presentation.dto.request.SaveSongRequest;
import com.board.presentation.dto.response.Top100Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.board.common.Const.API_URI;

@RequestMapping(value = API_URI + "/song")
@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping(value = "/top100", produces = MediaType.APPLICATION_JSON_VALUE)
    public Top100Response getTop100Song() {
        return Top100Response.from(songService.getTop100());
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveSong(@RequestBody SaveSongRequest saveSongRequest){
        songService.saveSong(saveSongRequest.toDSong());
    }

}
