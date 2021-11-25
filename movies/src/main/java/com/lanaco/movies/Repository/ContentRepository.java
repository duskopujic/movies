package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {
   List<Content>findAllByRating(Double rating);
}
