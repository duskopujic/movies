package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.MoviePeopleRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviePeopleRoleRepository extends JpaRepository<MoviePeopleRole,Integer> {
    List<MoviePeopleRole>findAllByMoviePeopleId(int Id);
}
