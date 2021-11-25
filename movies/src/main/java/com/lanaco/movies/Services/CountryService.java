package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country create(Country country);
        List<Country>findAll();
        Optional<Country> findOneById(int id);
        void deleteById(int id);
}
