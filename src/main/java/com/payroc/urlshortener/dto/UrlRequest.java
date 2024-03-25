package com.payroc.urlshortener.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlRequest {
    private String originalUrl;

    public UrlRequest(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
