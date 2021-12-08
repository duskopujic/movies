package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.LanguageDto;
import com.lanaco.movies.Models.Language;
import com.lanaco.movies.Services.LanguageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/language")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService){this.languageService=languageService;}

    @GetMapping(path = "/all")

    public ResponseEntity<List<Language>>findAllLanguage(){
        List<Language>allLanguage=languageService.findAll();
        return ResponseEntity.ok(allLanguage);
    }
    @GetMapping("")

    public ResponseEntity<Language> getOneLanguage(@RequestParam("id")int id){
        Optional<Language> optionalLanguage=languageService.findOneById(id);
        if(optionalLanguage.isPresent()){
            return ResponseEntity.ok(optionalLanguage.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(path = "/save")

    public ResponseEntity<Language>createLanguage(@RequestBody LanguageDto languageParam){
        Language createdLanguage = languageService.create(languageParam.toLanguage());
        return ResponseEntity.ok(createdLanguage);
    }

    @PutMapping("/update")

    public ResponseEntity<Language>updateLanguage(@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("code")String code){
    Optional<Language> optionalLanguage=languageService.findOneById(id);
    if(optionalLanguage.isPresent()){
        Language language = optionalLanguage.get();
        language.setName(name);
        language.setCode(code);
        languageService.create(language);
        return ResponseEntity.ok(language);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
    @DeleteMapping("/delete")

    public void deleteLanguage(@RequestParam("id")int id){
        languageService.deleteById(id);
}
}
