package com.board.application.service;

import com.board.common.util.Base62Util;
import com.board.infrastructure.mysql.UrlRepository;
import com.board.infrastructure.mysql.entity.UrlShorten;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    @Transactional
    public String generateShortenUrl(String originalUrl){

        UrlShorten urlShorten = new UrlShorten();
        urlShorten.setLongUrl(originalUrl);

        urlRepository.save(urlShorten);

        Long urlShortenId = urlShorten.getUrlShortenId();
        String encodedUrl = Base62Util.encode(urlShortenId);
        urlShorten.updateShortUrl(encodedUrl);

        return encodedUrl;
    }

    @Transactional(readOnly = true)
    public String getOriginalUriByShortenUrl(String shortenUrl){
        long decodedShortenUrl = Base62Util.decode(shortenUrl);

        log.info("decode shorten URL : " + decodedShortenUrl);

        UrlShorten urlShorten = urlRepository.findById(decodedShortenUrl)
                .orElseThrow(IllegalArgumentException::new);

        log.info("Original URL = {}", urlShorten.getLongUrl());

        return urlShorten.getLongUrl();
    }

}
