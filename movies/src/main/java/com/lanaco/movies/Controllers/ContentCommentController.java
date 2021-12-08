package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Content;
import com.lanaco.movies.Models.ContentComment;
import com.lanaco.movies.Models.Dto.ContentCommentDto;
import com.lanaco.movies.Models.Users;
import com.lanaco.movies.Repository.ContentCommentRepository;
import com.lanaco.movies.Repository.ContentRepository;
import com.lanaco.movies.Repository.UsersRepository;
import com.lanaco.movies.Services.ContentCommentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/Content-comment")
public class ContentCommentController {
    private final ContentCommentService contentCommentService;

    @Autowired
    private ContentCommentRepository contentCommentRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ContentRepository contentRepository;

   private ContentCommentController(ContentCommentService contentCommentService){
        this.contentCommentService=contentCommentService;
    }
    @GetMapping("")
    public ResponseEntity<List<ContentComment>> findAllContentComment(){
        List<ContentComment> allContentComment=contentCommentService.findAll();
        return ResponseEntity.ok(allContentComment);
    }
    @PostMapping("")
    public ResponseEntity<ContentComment>createContentComment(@RequestBody ContentCommentDto contentCommentDto){

       Users users=usersRepository.findById(contentCommentDto.getUsersId()).get();
        Content content = contentRepository.findById(contentCommentDto.getContentId()).get();
        ContentComment contentComment=contentCommentDto.toContentComment(users, content);

        return new ResponseEntity<>(contentCommentRepository.save(contentComment), HttpStatus.OK);
    }

}
