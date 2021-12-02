package com.lanaco.movies.Controllers;

import com.lanaco.movies.Configuration.UserDetailsServiceImpl;
import com.lanaco.movies.Models.AuthenticationRequest;
import com.lanaco.movies.Models.AuthenticationResponse;
import com.lanaco.movies.Models.Dto.UserDto;
import com.lanaco.movies.Models.Users;
import com.lanaco.movies.Services.UsersService;
import com.lanaco.movies.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")

public class UsersController {
    private final UsersService usersService;

    @Autowired(required = true)
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    JwtUtil jwtUtil;

    public UsersController(UsersService usersService){
        this.usersService=usersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> findAllUsers() {
        List<Users> allUsers = usersService.findAll();
        return ResponseEntity.ok(allUsers);

    }

    @PostMapping("/save")
    public ResponseEntity<Users> createUsers(@RequestBody UserDto userParam){
        Users createdUsers = usersService.create(userParam.toUsers());

        return ResponseEntity.ok(createdUsers);
    }

    @PostMapping("/login")
    public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
    throws Exception{
        try {
            Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUserName(),authenticationRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException ex){
        return new ResponseEntity<String>("Pogresni kredencijali",HttpStatus.BAD_REQUEST);
        }
         final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
         final String jwt = jwtUtil.generateToken(userDetails);
         return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt),HttpStatus.OK);
    }

}