package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.MoviePeople;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MoviePeopleDto {

    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    public String geneder;

public MoviePeople toMoviePeople(){
 return new MoviePeople()
         .setFirstName(firstName)
         .setLastName(lastName)
         .setBirthDate(birthDate)
         .setGeneder(geneder);
    }

}
