package com.lanaco.movies.Services;

import com.lanaco.movies.Models.MoviePeople;

import java.util.List;
import java.util.Optional;

public interface MoviePeopleService {
    MoviePeople create (MoviePeople moviePeople);
        List<MoviePeople>findAll();
        Optional<MoviePeople>findOneById(int id);
        void deleteById(int id);
}
