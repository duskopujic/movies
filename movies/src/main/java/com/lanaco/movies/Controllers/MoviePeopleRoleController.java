package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.MoviePeopleRoleDto;
import com.lanaco.movies.Models.MoviePeopleRole;
import com.lanaco.movies.Services.MoviePeopleRoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-people-role")
public class MoviePeopleRoleController {
    private final MoviePeopleRoleService moviePeopleRoleService;

    private MoviePeopleRoleController(MoviePeopleRoleService moviePeopleRoleService){
        this.moviePeopleRoleService=moviePeopleRoleService;
    }
    @GetMapping("")

    public ResponseEntity<List<MoviePeopleRole>>findAll(){
        List<MoviePeopleRole>allMoviePeopleRole = moviePeopleRoleService.findAll();
        return ResponseEntity.ok(allMoviePeopleRole);
    }
    @PostMapping("/")

    public ResponseEntity<MoviePeopleRole>createMoviePeopleRole(@RequestBody MoviePeopleRoleDto moviePeopleRoleParam){
        MoviePeopleRole createdMoviePeopleRole = moviePeopleRoleService.create(moviePeopleRoleParam.toMoviePeopleRole());
        return ResponseEntity.ok(createdMoviePeopleRole);
    }

}
