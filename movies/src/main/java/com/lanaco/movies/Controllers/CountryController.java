package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Country;
import com.lanaco.movies.Models.Dto.CountriDto;
import com.lanaco.movies.Services.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService=countryService;
    }

    @GetMapping("/all")

    public ResponseEntity<List<Country>>findAllCountry(){
        List<Country>allCountry=countryService.findAll();
        return ResponseEntity.ok(allCountry);
    }

    @GetMapping("/")

    public ResponseEntity<Country> getOneCountry(@RequestParam("id")int id){
        Optional<Country> optionalCountry = countryService.findOneById(id);
        if(optionalCountry.isPresent()){
            return ResponseEntity.ok(optionalCountry.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/save")

    public ResponseEntity<Country> createCountry(@RequestBody CountriDto countryParam){
        Country createdCountry=countryService.create(countryParam.toCountry());
                return ResponseEntity.ok(createdCountry);
    }
    @PutMapping("/update")

    public ResponseEntity<Country> updateCountry(@RequestParam("id")int id, @RequestParam("name")String name,@RequestParam("code")String code){
        Optional <Country> optionalCountry = countryService.findOneById(id);
        if(optionalCountry.isPresent()){
            Country country = optionalCountry.get();
            country.setName(name);
            country.setCode(code);
            countryService.create(country);
            return ResponseEntity.ok(country);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete")

    public void deleteCountry(@RequestParam("id")int id){
        countryService.deleteById(id);
    }
}
