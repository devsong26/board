package com.board.application.service;

import com.board.domain.DSong;
import com.board.infrastructure.mysql.SongRepository;
import com.board.infrastructure.mysql.entity.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    @Transactional(readOnly = true)
    public List<DSong> getTop100(){
        return songRepository.findByTop100Song();
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveSong(DSong dSong) {
        songRepository.save(dSong.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateSong(DSong dSong) {
        final Song song = getSong0(dSong.getSongId());

        if(dSong.getTitle() != null){
            song.setTitle(dSong.getTitle());
        }

        if(dSong.getLyrics() != null){
            song.setLyrics(dSong.getLyrics());
        }
    }

    private Song getSong0(Long songId) {
        final Optional<Song> songOpt = songRepository.findById(songId);

        if(songOpt.isEmpty()){
            throw new RuntimeException("존재하지 않는 음원 아이디 입니다.");
        }

        return songOpt.get();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteSong(DSong dSong) {
        final Song song = getSong0(dSong.getSongId());

        song.setDeleted(true);
    }

    @Transactional(readOnly = true)
    public DSong getSong(Long songId){
        return DSong.from(getSong0(songId));
    }

}
