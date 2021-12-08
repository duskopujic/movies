package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {
   List<Content> findAllByOrderByRating();

   List<Content> findAllByOrderByReleaseDate();

   @Query("select rating from Content")
   List<Double> findAllRating();
}
