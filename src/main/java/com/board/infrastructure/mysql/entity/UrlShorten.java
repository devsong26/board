package com.board.infrastructure.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UrlShorten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long urlShortenId;

    private String shortUrl;

    private String longUrl;

    public void updateShortUrl(String shortUrl){
        this.shortUrl = shortUrl;
    }

}
