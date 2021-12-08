package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.EpisodeDto;
import com.lanaco.movies.Models.Episode;
import com.lanaco.movies.Models.Season;
import com.lanaco.movies.Repository.EpisodeRepository;
import com.lanaco.movies.Repository.SeasonRepository;
import com.lanaco.movies.Services.EpisodeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/episode")
public class EpisodeController {
    private final EpisodeService episodeService;

    @Autowired
    public SeasonRepository seasonRepository;
    @Autowired
    public EpisodeRepository episodeRepository;

    public EpisodeController(EpisodeService episodeService){
        this.episodeService=episodeService;
    }

    @GetMapping("/")

    public ResponseEntity<List<Episode>>findAll(){
        List<Episode>allEpisode = episodeService.findAll();
        return ResponseEntity.ok(allEpisode);
    }
    @PostMapping("/")

    public ResponseEntity<Episode>createEpisode(@RequestBody EpisodeDto episodeDto){

        Season season=seasonRepository.findById(episodeDto.getSeasonId()).get();

        Episode episode = episodeDto.toEpisode(season);
        return new ResponseEntity<>(episodeRepository.save(episode), HttpStatus.OK);
    }
}
