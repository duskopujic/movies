package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.MovieRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRoleRepository extends JpaRepository<MovieRole,Integer> {

}
