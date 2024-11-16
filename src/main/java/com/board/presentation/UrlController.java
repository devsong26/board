package com.board.presentation;

import com.board.application.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten")
    public String generateShortenUrl(
            @RequestParam("url") final String originUrl) {
        return urlService.generateShortenUrl(originUrl);
    }

    @GetMapping("/shorten/{shortenUrl}")
    public void redirect(
            @PathVariable("shortenUrl") final String shortUrl,
            final HttpServletResponse response) throws IOException {
        final String originUrl = urlService.getOriginalUriByShortenUrl(shortUrl);

        final String encodeRedirectUri = response.encodeRedirectURL(originUrl);
        response.sendRedirect(encodeRedirectUri);
    }

}
