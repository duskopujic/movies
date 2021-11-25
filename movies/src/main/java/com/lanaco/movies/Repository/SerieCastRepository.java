package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.SerieCast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieCastRepository extends JpaRepository<SerieCast,Integer> {
    List<SerieCast>findAllByMoviePeopleId(int Id);
}
