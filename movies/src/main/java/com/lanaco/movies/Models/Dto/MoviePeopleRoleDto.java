package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.MoviePeopleRole;
import lombok.Data;

@Data
public class MoviePeopleRoleDto {
    private int moviePeopleId;
    private int movieRoleId;

    public MoviePeopleRole toMoviePeopleRole(){
        return new MoviePeopleRole()
                .setMoviePeopleId(moviePeopleId)
                .setMovieRoleId(movieRoleId);
    }
}
