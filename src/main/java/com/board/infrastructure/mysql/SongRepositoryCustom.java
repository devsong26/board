package com.board.infrastructure.mysql;

import com.board.domain.DSong;
import com.board.infrastructure.mysql.entity.Song;

import java.util.List;

public interface SongRepositoryCustom {

    List<DSong> findByTop100Song();

    void updateListenCntWithPessimisticLock(Long songId);

}
