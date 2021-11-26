package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Content;
import com.lanaco.movies.Models.ContentType;
import com.lanaco.movies.Models.Country;
import com.lanaco.movies.Models.Dto.ContentDto;
import com.lanaco.movies.Models.Language;
import com.lanaco.movies.Models.Request.ContentRequestDto;
import com.lanaco.movies.Models.Response.ContentResponseDto;
import com.lanaco.movies.Repository.ContentRepository;
import com.lanaco.movies.Repository.ContentTypeRepository;
import com.lanaco.movies.Repository.CountryRepository;
import com.lanaco.movies.Repository.LanguageRepository;
import com.lanaco.movies.Services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/content")
public class ContentController {
    private final ContentService contentService;

    @Autowired
    private ContentTypeRepository contentTypeRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private LanguageRepository languageRepository;

    public ContentController(ContentService contentService){
        this.contentService=contentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContentResponseDto>> findAll() {
        List<Content> allContent = contentService.findAll();

        List<ContentResponseDto> listResponse = allContent.stream().map(item -> item.toResponse()).collect(Collectors.toList());
        return ResponseEntity.ok(listResponse);
    }

  /*  private ContentResponseDto convertToResponse (Content content){
        return  new ContentResponseDto()
                .setTitle(content.getTitle())
                .setYear(content.getYear())
                .setDuration(content.getDuration())
                .setReleaseDate(content.getReleaseDate())
                .setRating(content.getRating())
                .setCoverLink(content.getCoverLink())
                .setTrailerLink(content.getTrailerLink())
                .setContentTypeName(content.getContentType().getName())
                .setCountryName(content.getCountry().getName())
                .setLanguageName(content.getLanguage().getName());
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ContentResponseDto>getOneById(@PathVariable("id")int id)
    {
        Optional<Content> optionalContent = contentService.findOneById(id);
        if(optionalContent.isPresent())
        {
            ContentResponseDto response = optionalContent.get().toResponse();
            return ResponseEntity.ok(response);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/save-movie")
    public ResponseEntity<Content> createContent(@RequestBody ContentDto contentDto) {

        ContentType contentType = contentTypeRepository.findById(contentDto.getContentTypeId()).get();
        //dohvati content type po contentDto.getContentTypeId();
        Country country = countryRepository.findById(contentDto.getCountryId()).get();
        Language language = languageRepository.findById(contentDto.getLanguageId()).get();

        Content content = contentDto.toContent(contentType, country, language);

        return new ResponseEntity<>(contentRepository.save(content), HttpStatus.OK);
    }
    /*@PutMapping("/update")
    public ResponseEntity<ContentResponseDto>updateContent(@RequestParam("id")int id,
                                                @RequestParam("title") String title,
                                                @RequestParam("year")int year,
                                                @RequestParam("duration")int duration,
                                                @RequestParam("releaseDate")LocalDate releaseDate,
                                                @RequestParam("rating")int rating,
                                                @RequestParam("coverLink")String coverLink,
                                                @RequestParam("trailerLink")String trailerLink,
                                                @RequestParam("contentTypeId")int contentTypeId,
                                                @RequestParam("countryId")int countryId,
                                                @RequestParam("languageId")int languageId)
    {
        Optional<Content> optionalContent = contentService.findOneById(id);

        ContentType contentType = contentTypeRepository.getById(contentTypeId);
        Country country = countryRepository.getById(countryId);
        Language language = languageRepository.getById(languageId);

        if(optionalContent.isPresent())
        {
         Content content = optionalContent.get();
         content.setTitle(title);
         content.setYear(year);
         content.setDuration(duration);
         content.setReleaseDate(releaseDate);
         content.setRating(rating);
         content.setCoverLink(coverLink);
         content.setTrailerLink(trailerLink);
         content.setContentType(contentType);
         content.setCountry(country);
         content.setLanguage(language);

         contentService.create(content);

        return ResponseEntity.ok(content.toResponse());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

     */

    @PutMapping("/update-movie")
    public ResponseEntity<ContentResponseDto> updateContent1(@RequestBody ContentRequestDto contentRequestDto) {
        Optional<Content> optionalContent = contentService.findOneById(contentRequestDto.getContentId());

        ContentType contentType = contentTypeRepository.getById(contentRequestDto.getContentTypeId());
        Country country = countryRepository.getById(contentRequestDto.getCountryId());
        Language language = languageRepository.getById(contentRequestDto.getLanguageId());


        if (optionalContent.isPresent()) {
            Content content = optionalContent.get();
            content.setTitle(contentRequestDto.getTitle());
            content.setYear(contentRequestDto.getYear());
            content.setDuration(contentRequestDto.getDuration());
            content.setReleaseDate(contentRequestDto.getReleaseDate());
            content.setRating(contentRequestDto.getRating());
            content.setCoverLink(content.getCoverLink());
            content.setTrailerLink(content.getTrailerLink());
            content.setContentType(contentType);
            content.setCountry(country);
            content.setLanguage(language);

            contentService.create(content);

            return ResponseEntity.ok(content.toResponse());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/delete")
    public void deleteContent(@RequestParam("id") int id) {
        contentService.deleteById(id);
    }

    @GetMapping("/by-rating")
    public ResponseEntity<List<Content>> findAllByOrderByRating() {
        List<Content> findAllRating = contentService.findAllByOrderByRating();
        return ResponseEntity.ok(findAllRating);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Double>> findAllRating() {
        List<Double> AllRating = contentService.findAllRating();
        return ResponseEntity.ok(AllRating);
    }

    @GetMapping("/by-release-date")
    public ResponseEntity<List<Content>> findAllByOrderByReleaseDate() {
        List<Content> findAllReleaseDate = contentService.findAllByOrderByReleaseDate();
        return ResponseEntity.ok(findAllReleaseDate);
    }


}

