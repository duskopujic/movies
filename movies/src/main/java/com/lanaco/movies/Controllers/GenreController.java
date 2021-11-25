package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.GenreDto;
import com.lanaco.movies.Models.Genre;
import com.lanaco.movies.Services.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "genre")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService){
        this.genreService=genreService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Genre>>findAllGenre(){
        List<Genre>allGenre=genreService.findAll();
        return ResponseEntity.ok(allGenre);
    }
    @GetMapping (path = "")
    public ResponseEntity<Genre> getOneGenreById(@RequestParam("id")int id){
        Optional<Genre> optionalGenre = genreService.findOneById(id);
        if(optionalGenre.isPresent()){
            return ResponseEntity.ok(optionalGenre.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/save")
    public ResponseEntity<Genre> createGenre(@RequestBody GenreDto genreParam){
        Genre createdGenre = genreService.create(genreParam.ToGenre());
                return ResponseEntity.ok(createdGenre);
    }
    @PutMapping("/update")
    public ResponseEntity<Genre>updateGenre(@RequestParam("id")int id,@RequestParam("name")String name) {
        Optional<Genre> optionalGenre = genreService.findOneById(id);
        if (optionalGenre.isPresent()) {
            Genre genre = optionalGenre.get();
            genre.setName(name);
            genreService.create(genre);
            return ResponseEntity.ok(genre);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete")
    public void deleteGenre(@RequestParam("id")int id){
        genreService.deleteById(id);
    }
}
