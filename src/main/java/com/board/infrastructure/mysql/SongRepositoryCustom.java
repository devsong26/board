package com.board.infrastructure.mysql;

import com.board.domain.DSong;
import com.board.presentation.dto.request.ListRequest;

import java.util.List;

public interface SongRepositoryCustom {

    List<DSong> findByTop100Song();

    void updateListenCntWithPessimisticLock(Long songId);

    List<DSong> findListByRequest(ListRequest request);

}
