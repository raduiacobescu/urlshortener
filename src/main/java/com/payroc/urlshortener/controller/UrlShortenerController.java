package com.payroc.urlshortener.controller;

import com.payroc.urlshortener.dto.HyperlinkDTO;
import com.payroc.urlshortener.dto.UrlResponse;
import com.payroc.urlshortener.model.Hyperlink;
import com.payroc.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UrlShortenerController {

    public static final String DOMAIN_NAME = "http://localhost:8080";
    private final UrlShortenerService urlShortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponse> shortenUrl(@RequestParam("url") String originalUrl) {
        Hyperlink shortenedUrl = urlShortenerService.createShortLink(originalUrl);

        HyperlinkDTO hyperlinkDTO = new HyperlinkDTO(shortenedUrl);

        return ResponseEntity.ok(new UrlResponse(hyperlinkDTO));
    }

    @GetMapping("/{shortenedVersion}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortenedVersion) {
        Optional<Hyperlink> originalUrl = urlShortenerService.findByShortenedVersion(shortenedVersion);

        if(!originalUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(originalUrl.get().getOriginalURL()))
                    .build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok("0.0.1");
    }

}