package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.ReviewDto;
import com.lanaco.movies.Models.Review;
import com.lanaco.movies.Services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Review>>findAll(){
        List<Review>allReview = reviewService.findAll();
        return ResponseEntity.ok(allReview);
    }
    @PostMapping("/")
    public ResponseEntity<Review>createReview(@RequestBody ReviewDto reviewParam){
        Review createdReview = reviewService.create(reviewParam.toReview());
        return ResponseEntity.ok(createdReview);
    }
}
