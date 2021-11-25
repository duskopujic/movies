package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.Episode;
import com.lanaco.movies.Repository.EpisodeRepository;
import com.lanaco.movies.Services.EpisodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    private final EpisodeRepository episodeRepository;

    public EpisodeServiceImpl(EpisodeRepository episodeRepository){
        this.episodeRepository=episodeRepository;
    }
    @Override
    public Episode create(Episode episode){
        return episodeRepository.save(episode);
    }
    @Override
    public List<Episode>findAll(){
        return episodeRepository.findAllByEpisodeId(0);
    }
}
