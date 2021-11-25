package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season,Integer>{
List<Season>findAllBySeasonId(int id);
}
