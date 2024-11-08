package com.board.infrastructure.mysql;

import static com.board.infrastructure.mysql.entity.QSong.song;

import com.board.domain.DSong;
import com.board.infrastructure.mysql.entity.Song;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SongRepositoryImpl implements SongRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<DSong> findByTop100Song() {
        return jpaQueryFactory.selectFrom(song)
                .orderBy(song.heart.desc())
                .limit(100)
                .fetch()
                .stream().map(DSong::from).toList();
    }

}
