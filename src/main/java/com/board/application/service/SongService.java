package com.board.application.service;

import com.board.domain.DSong;
import com.board.infrastructure.mysql.SongRepository;
import com.board.infrastructure.mysql.entity.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
