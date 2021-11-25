package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenreDto {
    private String name;

    public Genre ToGenre(){
        return new Genre()
                .setName(name);
    }
}

