package com.lanaco.movies.Models.Dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class ContentResponseDto {

    private int contentId;
    private String title;
    private int year;
    private int duration;
    private LocalDate releaseDate;
    private double rating;
    private String coverLink;
    private String trailerLink;
    private String contentTypeName;
    private String countryName;
    private String languageName;

}
