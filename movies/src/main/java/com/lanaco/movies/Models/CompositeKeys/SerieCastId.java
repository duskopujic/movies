package com.lanaco.movies.Models.CompositeKeys;

import java.io.Serializable;

public class SerieCastId implements Serializable {
    private int movieRoleId;
    private int moviePeopleId;
    private int seasonId;

    public SerieCastId (int movieRoleId, int moviePeopleId, int seasonId){
        this.movieRoleId=movieRoleId;
        this.moviePeopleId=moviePeopleId;
        this.seasonId=seasonId;
    }
}
