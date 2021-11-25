package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Review;

import java.util.List;

public interface ReviewService {
    Review create(Review review);
    List<Review>findAll();
}
