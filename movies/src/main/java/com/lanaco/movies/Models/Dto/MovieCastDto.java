package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.MovieCast;
import lombok.Data;

@Data
public class MovieCastDto {
private int contentId;
private int movieRoleId;
private int moviePeopleId;

public MovieCast toMovieCast(){
    return new MovieCast()
            .setContentId(contentId)
            .setMovieRoleId(movieRoleId)
            .setMoviePeopleId(moviePeopleId);
}
}
