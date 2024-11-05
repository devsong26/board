package com.board.infrastructure.mysql;

import com.board.infrastructure.mysql.entity.Song;

import java.util.List;

public interface SongRepositoryCustom {

    List<Song> findByTop100Song();

}
