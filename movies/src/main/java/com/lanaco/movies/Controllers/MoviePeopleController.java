package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.MoviePeopleDto;
import com.lanaco.movies.Models.MoviePeople;
import com.lanaco.movies.Services.MoviePeopleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.cache.annotation.CachePut;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "/movie-people")
public class MoviePeopleController
{
    private final MoviePeopleService moviePeopleService;

    public MoviePeopleController(MoviePeopleService moviePeopleService)
    {
        this.moviePeopleService=moviePeopleService;
    }
    @GetMapping("/all")

    public ResponseEntity<List<MoviePeople>>findAllMoviePeople()
    {
        List<MoviePeople>allMoviePeople= moviePeopleService.findAll();
        return ResponseEntity.ok(allMoviePeople);
    }
    @GetMapping("")

    public ResponseEntity<MoviePeople>getOneMoviePeople(@RequestParam("id")int id){
        Optional<MoviePeople> optionalMoviePeople = moviePeopleService.findOneById(id);
        if(optionalMoviePeople.isPresent())
        {
            return ResponseEntity.ok(optionalMoviePeople.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/save")

    public  ResponseEntity<MoviePeople> create(@RequestBody MoviePeopleDto moviePeopleParam)
    {
        MoviePeople createdMoviePeople = moviePeopleService.create(moviePeopleParam.toMoviePeople());
                return ResponseEntity.ok(createdMoviePeople);
    }
    @PutMapping("/update")

    public ResponseEntity<MoviePeople> updateMoviePeople(@RequestParam("id")int id,
                                                         @RequestParam("firstName")String firstName,
                                                         @RequestParam("lastName")String lastName,
                                                         @RequestParam("birthDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
                                                         @RequestParam("gender")String gender)
    {
        Optional<MoviePeople> optionalMoviePeople = moviePeopleService.findOneById(id);
        if (optionalMoviePeople.isPresent())
        {
            MoviePeople moviePeople = optionalMoviePeople.get();
            moviePeople.setFirstName(firstName);
            moviePeople.setLastName(lastName);
            moviePeople.setBirthDate(birthDate);
            moviePeople.setGeneder(gender);
            moviePeopleService.create(moviePeople);
            return ResponseEntity.ok(moviePeople);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete")

    public void deleteMoviePeople(@RequestParam("id")int id){
        moviePeopleService.deleteById(id);
    }
}
