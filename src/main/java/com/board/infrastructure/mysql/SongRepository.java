package com.board.infrastructure.mysql;

import com.board.infrastructure.mysql.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long>, SongRepositoryCustom {



}
