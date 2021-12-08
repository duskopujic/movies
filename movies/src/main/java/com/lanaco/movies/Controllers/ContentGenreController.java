package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.ContentGenre;
import com.lanaco.movies.Models.Dto.ContentGenreDto;
import com.lanaco.movies.Services.ContentGenreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "content-genre")
public class ContentGenreController {
    private final ContentGenreService contentGenreService;

    public ContentGenreController(ContentGenreService contentGenreService){
        this.contentGenreService = contentGenreService;
    }
    @GetMapping("/")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })

    public ResponseEntity<List<ContentGenre>>findAll(){
        List<ContentGenre>allContentGenre = contentGenreService.findAll();
        return ResponseEntity.ok(allContentGenre);
    }
    @PostMapping("/")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })

    public ResponseEntity<ContentGenre>createContentGenre(@RequestBody ContentGenreDto contentGenreParam){
        ContentGenre createdContentGenre = contentGenreService.create(contentGenreParam.toContentGenre());
        return ResponseEntity.ok(createdContentGenre);
    }
}
