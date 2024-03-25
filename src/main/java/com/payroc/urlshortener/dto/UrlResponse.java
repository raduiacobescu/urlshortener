package com.payroc.urlshortener.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlResponse {
    private HyperlinkDTO hyperlinkDTO;

    public UrlResponse(HyperlinkDTO hyperlinkDTO) {
        this.hyperlinkDTO = hyperlinkDTO;
    }
}
