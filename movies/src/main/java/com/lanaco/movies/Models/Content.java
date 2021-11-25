package com.lanaco.movies.Models;

import com.lanaco.movies.Models.Dto.ContentResponseDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "content",schema = "public")
@Accessors(chain = true)
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contentId")
    public int contentId;
    @ManyToOne
    @JoinColumn(name = "contentTypeId")
    public ContentType contentType;
    @ManyToOne
    @JoinColumn(name = "countryId")
    public Country country;
    @ManyToOne
    @JoinColumn(name = "languageId")
    public Language language;

    public String title;
    public int year;
    public int duration;
    public LocalDate releaseDate;
    public double rating;
    public String coverLink;
    public String trailerLink;


    public ContentResponseDto toResponse (){
        return  new ContentResponseDto()
                .setContentId(contentId)
                .setTitle(title)
                .setYear(year)
                .setDuration(duration)
                .setReleaseDate(releaseDate)
                .setRating(rating)
                .setCoverLink(coverLink)
                .setTrailerLink(trailerLink)
                .setContentTypeName(contentType.getName())
                .setCountryName(country.getName())
                .setLanguageName(language.getName());
    }
}
