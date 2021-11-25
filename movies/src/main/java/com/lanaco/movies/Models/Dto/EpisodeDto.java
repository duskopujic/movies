package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Episode;
import com.lanaco.movies.Models.Season;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EpisodeDto {
    private int seasonId;
    private String name;
    private  int duration;
    private int episodeNumber;

    public Episode toEpisode(Season season){

        return new Episode()

                .setSeason(season)
                .setName(name)
                .setDuration(duration)
                .setEpisodeNumber(episodeNumber);
    }
}

