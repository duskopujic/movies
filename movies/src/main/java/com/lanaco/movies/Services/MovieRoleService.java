package com.lanaco.movies.Services;

import com.lanaco.movies.Models.MovieRole;

import java.util.List;
import java.util.Optional;

public interface MovieRoleService {
MovieRole create(MovieRole movieRole);
List<MovieRole>findAll();
Optional<MovieRole> findOneById(int id);
void deleteById(int id);
}
