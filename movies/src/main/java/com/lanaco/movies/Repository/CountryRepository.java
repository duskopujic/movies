package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>  {
    List<Country>findAllByCountryIdGreaterThanOrderByCountryIdDesc(int id);
}
