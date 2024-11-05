package com.board.infrastructure.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Board {

    @Id
    private String id;
    private String title;

    @Version
    private Integer version;

}
