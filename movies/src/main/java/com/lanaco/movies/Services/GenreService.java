package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Genre create(Genre genre);
        List<Genre> findAll();
        Optional<Genre> findOneById(int id);
        void deleteById(int id);
}
