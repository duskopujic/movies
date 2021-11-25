package com.lanaco.movies.Services;

import com.lanaco.movies.Models.ContentGenre;

import java.util.List;

public interface ContentGenreService {
    ContentGenre create(ContentGenre contentGenre);
    List<ContentGenre>findAll();
}
