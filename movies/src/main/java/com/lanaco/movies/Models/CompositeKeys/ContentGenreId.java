package com.lanaco.movies.Models.CompositeKeys;

import java.io.Serializable;

public class ContentGenreId implements Serializable {

    private int contentId;
    private int genreId;

    public ContentGenreId(int contentId, int genreId){
        this.contentId=contentId;
        this.genreId=genreId;
    }
}
