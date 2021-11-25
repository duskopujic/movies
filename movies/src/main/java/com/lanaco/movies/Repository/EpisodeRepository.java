package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode,Integer> {
    List<Episode>findAllByEpisodeId(int Id);
}
