package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.UserDto;
import com.lanaco.movies.Models.Users;
import com.lanaco.movies.Services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")

public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService=usersService;
    }


    @GetMapping("")
    public ResponseEntity<List<Users>> findAllUsers() {
        List<Users> allUsers = usersService.findAll();
        return ResponseEntity.ok(allUsers);

    }

    @PostMapping("")
    public ResponseEntity<Users> createUsers(@RequestBody UserDto userParam){
        Users createdUsers = usersService.create(userParam.toUsers());

        return ResponseEntity.ok(createdUsers);
    }

}