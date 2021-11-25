package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Content;
import com.lanaco.movies.Models.Dto.SeasonDto;
import com.lanaco.movies.Models.Season;
import com.lanaco.movies.Repository.ContentRepository;
import com.lanaco.movies.Repository.SeasonRepository;
import com.lanaco.movies.Services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/season")
public class SeasonController {
    private final SeasonService seasonService;

    @Autowired
    private SeasonRepository seasonRepository;
    @Autowired
    private ContentRepository contentRepository;

    public SeasonController(SeasonService seasonService){
        this.seasonService= seasonService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Season>>findAllSeason(){
        List<Season> allSeason=seasonService.findAll();
        return ResponseEntity.ok(allSeason);
    }
    @PostMapping("/")
    public ResponseEntity<Season> createSeason(@RequestBody SeasonDto seasonDto){

        Content content = contentRepository.findById(seasonDto.getContentId()).get();

        Season season = seasonDto.toSeason(content);
        return new ResponseEntity<>(seasonRepository.save(season), HttpStatus.OK);
    }
}
