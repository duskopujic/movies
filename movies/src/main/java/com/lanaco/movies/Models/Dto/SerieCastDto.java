package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.SerieCast;
import lombok.Data;

@Data
public class SerieCastDto {
    private int movieRoleId;
    private  int moviePeopleId;
    private int seasonId;

    public SerieCast toSerieCast(){
        return new SerieCast()
                .setMovieRoleId(movieRoleId)
                .setMoviePeopleId(moviePeopleId)
                .setSeasonId(seasonId);
    }
}
