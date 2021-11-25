package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Review;
import lombok.Data;

@Data
public class ReviewDto {
private int userId;
private int contentId;
private int rating;
private boolean favorite;

public Review toReview(){
    return new Review()
            .setUserId(userId)
            .setContentId(contentId)
            .setRating(rating)
            .setFavorite(favorite);
}

}
