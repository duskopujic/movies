package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Content;

import java.util.List;
import java.util.Optional;

public interface ContentService {
    Content create(Content content);

    List<Content> findAll();

    Optional<Content> findOneById(int id);

    List<Content> findAllByOrderByRating();

    void deleteById(int id);

    List<Double> findAllRating();

    List<Content> findAllByOrderByReleaseDate();
}
