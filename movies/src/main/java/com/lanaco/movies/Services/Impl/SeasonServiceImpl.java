package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.Season;
import com.lanaco.movies.Repository.SeasonRepository;
import com.lanaco.movies.Services.SeasonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;

     public SeasonServiceImpl(SeasonRepository seasonRepository){
         this.seasonRepository=seasonRepository;
     }
     @Override
    public Season create(Season season){
         return seasonRepository.save(season);
     }
     @Override
    public List<Season>findAll(){
         return seasonRepository.findAllBySeasonId(0);
     }
}
