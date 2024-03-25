package com.payroc.urlshortener.repository;

import com.payroc.urlshortener.model.Hyperlink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HyperlinkRepository extends JpaRepository<Hyperlink, Long> {
    Optional<Hyperlink> findByShortenedVersion(String shortenedVersion);

}