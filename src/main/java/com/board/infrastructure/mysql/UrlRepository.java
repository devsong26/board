package com.board.infrastructure.mysql;

import com.board.infrastructure.mysql.entity.UrlShorten;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlShorten, Long> {
}
