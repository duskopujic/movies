package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.ContentGenre;
import com.lanaco.movies.Models.Dto.ContentGenreDto;
import com.lanaco.movies.Services.ContentGenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "contentGenre")
public class ContentGenreController {
    private final ContentGenreService contentGenreService;

    public ContentGenreController(ContentGenreService contentGenreService){
        this.contentGenreService = contentGenreService;
    }
    @GetMapping("/")
    public ResponseEntity<List<ContentGenre>>findAll(){
        List<ContentGenre>allContentGenre = contentGenreService.findAll();
        return ResponseEntity.ok(allContentGenre);
    }
    @PostMapping("/")
    public ResponseEntity<ContentGenre>createContentGenre(@RequestBody ContentGenreDto contentGenreParam){
        ContentGenre createdContentGenre = contentGenreService.create(contentGenreParam.toContentGenre());
        return ResponseEntity.ok(createdContentGenre);
    }
}
