package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.Country;
import com.lanaco.movies.Repository.CountryRepository;
import com.lanaco.movies.Services.CountryService;
import com.lanaco.movies.Services.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    public CountryServiceImpl(CountryRepository countryRepository){this.countryRepository=countryRepository;}

    @Override
    public Country create(Country country){
        return countryRepository.save(country);
    }
    @Override
    public List<Country>findAll(){
        return countryRepository.findAllByCountryIdGreaterThanOrderByCountryIdDesc(0);
    }
    @Override
    public Optional<Country> findOneById(int id){
        return countryRepository.findById(id);
    }
    @Override
    public void deleteById(int id){
        countryRepository.deleteById(id);
    }
}
