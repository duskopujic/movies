package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.Review;
import com.lanaco.movies.Repository.ReviewRepository;
import com.lanaco.movies.Services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }
    @Override
    public Review create(Review review){
        return reviewRepository.save(review);
    }
    @Override
    public List<Review>findAll(){
        return reviewRepository.findAllByUserId(0);
    }
}
