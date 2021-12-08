package com.lanaco.movies.Controllers;

import com.lanaco.movies.Configuration.UserDetailsServiceImpl;
import com.lanaco.movies.Exception.RegistrationException;
import com.lanaco.movies.Models.*;
import com.lanaco.movies.Models.CompositeKeys.UserRoleId;
import com.lanaco.movies.Models.Dto.UserDto;
import com.lanaco.movies.Repository.RoleRepository;
import com.lanaco.movies.Repository.UserRoleRepository;
import com.lanaco.movies.Repository.UsersRepository;
import com.lanaco.movies.Services.UsersService;
import com.lanaco.movies.Utils.JwtUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UsersController(UsersService usersService){
        this.usersService=usersService;
    }

    @GetMapping("/all")

    public ResponseEntity<List<Users>> findAllUsers() {
        List<Users> allUsers = usersService.findAll();
        return ResponseEntity.ok(allUsers);

    }


    @PostMapping("/login")

    public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
    throws Exception{
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUserName(),authenticationRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException ex){
        return new ResponseEntity<String>("Pogresni kredencijali!",HttpStatus.BAD_REQUEST);
        }
         final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
         final String jwt = jwtUtil.generateToken(userDetails);
         return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt),HttpStatus.OK);
    }
    @PostMapping("/registracija")

    public Users save(UserDto userDto) throws RegistrationException {
        if (!usersService.existByEmail (userDto.getEmail())
                && !usersService.existByUsername(userDto.getUserName())) {

            Users users = usersService.create(buildUserFromDto(userDto));
            userDto.getRoleId().forEach(roleId -> {
                UserRoleId userRoleId = new UserRoleId(users.getUserId(), roleId);
                Role role = roleRepository.getById(roleId);
                userRoleRepository.save(new UserRole(userRoleId, users, role));
            });
            return usersRepository.save(users);
        }

        throw new RegistrationException("E-mail i username moraju biti jedinstveni!");
    }
    @DeleteMapping("/delete")

    public void deleteUser(@RequestParam("id")int id){
        usersService.deleteById(id);
    }



    private Users buildUserFromDto(UserDto userDto){
        Users users = new Users();
        if (userDto.getUserId()!=null) {
            users.setUserId(userDto.getUserId());
        }
        users.setUserName(userDto.getUserName());
        users.setFirstName(userDto.getFirstName());
        users.setLastName(userDto.getLastName());
        users.setPhoneNumber(userDto.getPhoneNumber());
        users.setAdress(userDto.getAdress());
        users.setEmail(userDto.getEmail());
        users.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return users;
    }
}