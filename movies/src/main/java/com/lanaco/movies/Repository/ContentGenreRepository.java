package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.ContentGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentGenreRepository extends JpaRepository<ContentGenre,Integer> {
    List<ContentGenre>findAllByContentId(int Id);
}
