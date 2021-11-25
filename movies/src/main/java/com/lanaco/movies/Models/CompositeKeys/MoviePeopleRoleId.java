package com.lanaco.movies.Models.CompositeKeys;

import com.lanaco.movies.Models.MoviePeopleRole;

import java.io.Serializable;

public class MoviePeopleRoleId implements Serializable {

    private int movieRoleId;
    private int moviePeopleId;

    public MoviePeopleRoleId (int movieRoleId, int moviePeopleId){
        this.movieRoleId=movieRoleId;
        this.moviePeopleId=moviePeopleId;
    }
}
