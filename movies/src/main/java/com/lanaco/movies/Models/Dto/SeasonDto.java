package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Content;
import com.lanaco.movies.Models.Season;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeasonDto {
    private String name;
    private int seasonNumber;
    private int contentId;

    public Season toSeason(Content content){

        return new Season()
                .setContent(content)
                .setName(name)
                .setSeasonNumber(seasonNumber);

    }

}
