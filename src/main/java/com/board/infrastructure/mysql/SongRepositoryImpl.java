package com.board.infrastructure.mysql;

import com.board.domain.DSong;
import com.board.presentation.dto.request.ListRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.board.infrastructure.mysql.entity.QSong.song;

@Repository
@RequiredArgsConstructor
public class SongRepositoryImpl implements SongRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<DSong> findByTop100Song() {
        return jpaQueryFactory.selectFrom(song)
                .where(song.isDeleted.eq(false))
                .orderBy(song.heart.desc())
                .limit(100)
                .fetch()
                .stream().map(DSong::from).toList();
    }

    @Override
    public void updateListenCntWithPessimisticLock(Long songId) {
        jpaQueryFactory.update(song)
                .where(song.id.eq(songId))
                .set(song.listenCnt, song.listenCnt.add(1))
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .execute();
    }

    @Override
    public List<DSong> findListByRequest(ListRequest request) {
        final BooleanBuilder builder = new BooleanBuilder();

        if(request.getTitle() != null){
            builder.and(song.title.contains(request.getTitle()));
        }

        if(request.getLyrics() != null){
            builder.and(song.lyrics.contains(request.getLyrics()));
        }

        if(request.getIsDeleted() != null){
            builder.and(song.isDeleted.eq(request.getIsDeleted()));
        }

        if(request.getIsForeign() != null){
            builder.and(song.isForeign.eq(request.getIsForeign()));
        }

        if(request.getCountry() != null) {
            builder.and(song.country.eq(request.getCountry()));
        }

        builder.and(song.regDate.between(request.getStartAt(), request.getEndAt()));

        return jpaQueryFactory.selectFrom(song)
                .where()
                .offset(request.getPage() * request.getSize())
                .limit(request.getSize())
                .fetch()
                .stream().map(DSong::from).toList();
    }

}
