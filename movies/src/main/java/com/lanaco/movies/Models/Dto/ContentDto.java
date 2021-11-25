package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Content;
import com.lanaco.movies.Models.ContentType;
import com.lanaco.movies.Models.Country;
import com.lanaco.movies.Models.Language;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ContentDto {

    private String title;
    private int year;
    private int duration;
    private LocalDate releaseDate;
    private double rating;
    private String coverLink;
    private String trailerLink;
    private Integer contentTypeId;
    private Integer countryId;
    private Integer languageId;

    public Content toContent(ContentType contentType, Country country, Language language){

        return new Content()

                .setTitle(title)
                .setContentType(contentType)
                .setCountry(country)
                .setYear(year)
                .setDuration(duration)
                .setReleaseDate(releaseDate)
                .setRating(rating)
                .setCoverLink(coverLink)
                .setTrailerLink(trailerLink)
                .setLanguage(language);


    }
}
