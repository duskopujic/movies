package com.lanaco.movies.Models.Request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContentRequestDto {
    public int contentId;
    public String title;
    public int year;
    public int duration;
    public LocalDate releaseDate;
    public int rating;
    public String coverLink;
    public String trailerLink;
    public int contentTypeId;
    public int countryId;
    public int languageId;

}
