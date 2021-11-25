package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.MovieRole;

public class MovieRoleDto {

    public String name;
    public MovieRole toMovieRole(){
        return new MovieRole()
        .setName(name);
    }

}
