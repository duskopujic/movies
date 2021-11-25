package com.lanaco.movies.Models.CompositeKeys;

import java.io.Serializable;

public class ReviewId implements Serializable {

    private int userId;
    private int contentId;

    public ReviewId(int userId, int contentId){
        this.userId = userId;
        this.contentId = contentId;
    }
}
