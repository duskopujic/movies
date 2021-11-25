package com.lanaco.movies.Models.CompositeKeys;

import com.lanaco.movies.Models.MovieCast;
import lombok.Data;

import java.io.Serializable;


public class MovieCastId implements Serializable {
    private int contentId;
    private int movieRoleId;
    private int moviePeopleId;

    public MovieCastId(int contentId, int movieRoleId, int moviePeopleId){
        this.contentId=contentId;
        this.movieRoleId=movieRoleId;
        this.moviePeopleId=moviePeopleId;
    }
}
