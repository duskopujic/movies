package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.MovieCastDto;
import com.lanaco.movies.Models.MovieCast;
import com.lanaco.movies.Services.MovieCastService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movie-cast")
public class MovieCastController {
    private final MovieCastService movieCastService;

    public MovieCastController(MovieCastService movieCastService){
        this.movieCastService=movieCastService;
    }
    @GetMapping("/")

    public ResponseEntity<List<MovieCast>>findAll(){
        List<MovieCast>allMovieCast=movieCastService.findAll();
        return ResponseEntity.ok(allMovieCast);
    }
    @PostMapping("/")

    public ResponseEntity<MovieCast>createMovieCast(@RequestBody MovieCastDto movieCastParam){
        MovieCast createdMovieCast = movieCastService.create(movieCastParam.toMovieCast());
        return ResponseEntity.ok(createdMovieCast);
    }
}
