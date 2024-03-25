package com.payroc.urlshortener.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Period;

@Getter
@Setter
@Entity
@JsonSerialize
public class Hyperlink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originalURL;

    @Column(nullable = false, unique = true)
    private String shortenedVersion;

    @Column
    private LocalDateTime expirationDate;

    public Hyperlink(String name, String shortenedVersion) {
        this.originalURL = name;
        this.shortenedVersion = shortenedVersion;
        this.expirationDate = LocalDateTime.now().plus(Period.ofYears(1));
    }

    public Hyperlink() {

    }
}