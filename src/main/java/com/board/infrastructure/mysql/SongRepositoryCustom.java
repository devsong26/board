package com.board.infrastructure.mysql;

import com.board.domain.DSong;

import java.util.List;

public interface SongRepositoryCustom {

    List<DSong> findByTop100Song();

}
