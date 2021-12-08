package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.MovieRoleDto;
import com.lanaco.movies.Models.MovieRole;
import com.lanaco.movies.Services.MovieRoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/movie-role")
public class MovieRoleController {
    private final MovieRoleService movieRoleService;
    public MovieRoleController(MovieRoleService movieRoleService)
    {
        this.movieRoleService=movieRoleService;
    }

    @GetMapping (path = "/all")

    public ResponseEntity<List<MovieRole>>findAllMovieRole()
    {
        List<MovieRole>allMovieRole=movieRoleService.findAll();
        return ResponseEntity.ok(allMovieRole);
    }
    @GetMapping("")

    public ResponseEntity<MovieRole>getOneMovieRole(@RequestParam("id")int id)
    {
        Optional<MovieRole> optionalMovieRole = movieRoleService.findOneById(id);
        if(optionalMovieRole.isPresent())
        {
            return ResponseEntity.ok(optionalMovieRole.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping ("/save")

    public ResponseEntity<MovieRole>createMovieRole(@RequestBody MovieRoleDto movieRoleParam)
    {
        MovieRole createdMovieRole=movieRoleService.create(movieRoleParam.toMovieRole());
        return ResponseEntity.ok(createdMovieRole);
    }
    @PutMapping("/update")

    public ResponseEntity<MovieRole>updateMovieRole(@RequestParam("id")int id,
                                                    @RequestParam("name")String name)
    {
    Optional<MovieRole> optionalMovieRole = movieRoleService.findOneById(id);
    if(optionalMovieRole.isPresent())
    {
        MovieRole movieRole = optionalMovieRole.get();
        movieRole.setName(name);
        movieRoleService.create(movieRole);
        return ResponseEntity.ok(movieRole);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete")

    public void deleteMovieRole(@RequestParam("id")int id)
    {
        movieRoleService.deleteById(id);
    }
}
