package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.MoviePeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviePeopleRepository extends JpaRepository<MoviePeople, Integer> {
    List<MoviePeople>findAllByMoviePeopleIdGreaterThanOrderByMoviePeopleIdDesc(int id);
}
