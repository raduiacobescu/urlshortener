package com.payroc.urlshortener.service;

import com.payroc.urlshortener.model.Hyperlink;
import com.payroc.urlshortener.repository.HyperlinkRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlShortenerService {

    private final HyperlinkRepository linkRepository;

    @Autowired
    public UrlShortenerService(HyperlinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Hyperlink createShortLink(String originalUrl) {
        String shortCode = makeShortCode(originalUrl);
        Hyperlink link = new Hyperlink(originalUrl, shortCode);

        return linkRepository.save(link);
    }

    public Optional<Hyperlink> findByShortenedVersion(String shortenedVersion) {
        return linkRepository.findByShortenedVersion(shortenedVersion);
    }

    private String makeShortCode(String originalUrl) {
        int hash = originalUrl.hashCode();
        String encoded = Base64.encodeBase64URLSafeString(Integer.toString(hash).getBytes());
        return encoded;
    }

}
