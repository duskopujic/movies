package com.lanaco.movies.Services;

import com.lanaco.movies.Models.MoviePeopleRole;

import java.util.List;

public interface MoviePeopleRoleService {
    MoviePeopleRole create(MoviePeopleRole moviePeopleRole);
    List<MoviePeopleRole>findAll();
}
