package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.MovieCast;
import com.lanaco.movies.Repository.MovieCastRepository;
import com.lanaco.movies.Services.MovieCastService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieCastServiceImpl implements MovieCastService {

    private final MovieCastRepository movieCastRepository;

    public MovieCastServiceImpl(MovieCastRepository movieCastRepository){
        this.movieCastRepository=movieCastRepository;
    }
    @Override
    public MovieCast create(MovieCast movieCast){
        return movieCastRepository.save(movieCast);
    }
    @Override
    public List<MovieCast>findAll(){
        return movieCastRepository.findAllByContentId(0);
    }
}
