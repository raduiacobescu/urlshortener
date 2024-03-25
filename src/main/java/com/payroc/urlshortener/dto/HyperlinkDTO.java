package com.payroc.urlshortener.dto;

import com.payroc.urlshortener.model.Hyperlink;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.payroc.urlshortener.controller.UrlShortenerController.DOMAIN_NAME;

@Getter
@Setter
public class HyperlinkDTO {
    private String originalURL;
    private String shortenedVersion; // Full URL including DOMAIN_NAME
    private LocalDateTime expirationDate;

    public HyperlinkDTO(Hyperlink hyperlink) {
        this.originalURL = hyperlink.getOriginalURL();
        this.shortenedVersion = DOMAIN_NAME + "/" + hyperlink.getShortenedVersion();
        this.expirationDate = hyperlink.getExpirationDate();
    }
}