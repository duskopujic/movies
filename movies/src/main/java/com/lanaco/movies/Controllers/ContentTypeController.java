package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.ContentType;
import com.lanaco.movies.Models.Dto.ContentTypeDto;
import com.lanaco.movies.Services.ContentTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "/content-type")
public class ContentTypeController {
    private final ContentTypeService contentTypeService;
    public ContentTypeController(ContentTypeService contentTypeService){
        this.contentTypeService = contentTypeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ContentType>>findAllContentType(){
        List<ContentType>allContentType = contentTypeService.findAll();
        return ResponseEntity.ok(allContentType);
    }

    @GetMapping("")
    public ResponseEntity<ContentType> getOneContentType(@RequestParam("id") int id)
    {
        Optional<ContentType> optionalContentType = contentTypeService.findOneById(id);
        if(optionalContentType.isPresent())
        {
            return ResponseEntity.ok(optionalContentType.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<ContentType>createContentType(@RequestBody ContentTypeDto contentTypeParam){
        ContentType createdContentType=contentTypeService.create(contentTypeParam.toContentType());
        return ResponseEntity.ok(createdContentType);
    }

    @PutMapping("/update")
    public ResponseEntity<ContentType> updateContentType(@RequestParam("id") int id,
                                                         @RequestParam("name") String name)
    {
        Optional <ContentType> optionalContentType = contentTypeService.findOneById(id);
        if(optionalContentType.isPresent()) {
            ContentType contentType = optionalContentType.get();
            contentType.setName(name);
            contentTypeService.create(contentType);
            return ResponseEntity.ok(contentType);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public void deleteContentType(@RequestParam("id") int id) {
        contentTypeService.deleteById(id);
    }
}
