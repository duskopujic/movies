package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.MovieCast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieCastRepository extends JpaRepository<MovieCast,Integer> {
    List<MovieCast>findAllByContentId(int Id);
}
