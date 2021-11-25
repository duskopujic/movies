package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.MoviePeople;
import com.lanaco.movies.Repository.MoviePeopleRepository;
import com.lanaco.movies.Services.MoviePeopleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviePeopleServiceImpl implements MoviePeopleService {
    private final MoviePeopleRepository moviePeopleRepository;

    public MoviePeopleServiceImpl(MoviePeopleRepository moviePeopleRepository){
        this.moviePeopleRepository=moviePeopleRepository;
    }
 @Override
    public MoviePeople create(MoviePeople moviePeople){
        return moviePeopleRepository.save(moviePeople);
 }
 @Override
    public List<MoviePeople>findAll(){
        return moviePeopleRepository.findAllByMoviePeopleIdGreaterThanOrderByMoviePeopleIdDesc(0);
 }
    @Override
    public Optional<MoviePeople> findOneById(int id) {
        return moviePeopleRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
         moviePeopleRepository.deleteById(id);
    }

}
