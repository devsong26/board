package com.board.presentation;

import com.board.application.service.SongService;
import com.board.presentation.dto.request.DeleteSongRequest;
import com.board.presentation.dto.request.HeartRequest;
import com.board.presentation.dto.request.SaveSongRequest;
import com.board.presentation.dto.request.UpdateSongRequest;
import com.board.presentation.dto.response.SongResponse;
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

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateSong(
            final @RequestBody UpdateSongRequest request){
        songService.updateSong(request.toDSong());
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSong(
            final @RequestBody DeleteSongRequest request) {
        songService.deleteSong(request.toDSong());
    }

    @GetMapping(value = "/{songId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SongResponse getSong(final @PathVariable("songId") Long songId){
        return SongResponse.from(songService.getSong(songId));
    }

    @PatchMapping(value = "/{songId}/listen")
    public void listen(final @PathVariable("songId") Long songId) {
        // todo 사용자의 들었던 노래 목록에 있어야 함
        songService.listenSong(songId);
    }

    @PatchMapping(value = "/heart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void heart(final HeartRequest request) {
        // todo 사용자가 좋아요를 눌렀다면 그 기록이 남아야 함
        songService.toggleHeart(request);
    }

}
