package com.lanaco.movies.Services;

import com.lanaco.movies.Models.MovieCast;

import java.util.List;

public interface MovieCastService {
    MovieCast create(MovieCast movieCast);
        List<MovieCast>findAll();

}
