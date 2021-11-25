package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Country;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountriDto {
    private String name;
    private String code;

    public Country toCountry(){
        return new Country()
                .setName(name)
                .setCode(code);

    }
}
