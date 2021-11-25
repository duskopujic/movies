package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Episode;

import java.util.List;

public interface EpisodeService {
    Episode create(Episode episode);
        List<Episode>findAll();

}
