package com.board.infrastructure.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Board {

    @Id
    private Long id;
    private String title;

    @Version
    private Integer version;

}
