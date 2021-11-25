package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Language;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LanguageDto {
    public int languageId;
    public String name;
    public  String code;

 public  Language toLanguage(){
     return new Language()
             .setLanguageId(languageId)
             .setName(name)
             .setCode(code);
    }
}
