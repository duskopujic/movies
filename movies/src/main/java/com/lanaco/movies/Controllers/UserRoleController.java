package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.UserRoleDto;
import com.lanaco.movies.Models.UserRole;
import com.lanaco.movies.Services.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/userRole")
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService){
        this.userRoleService =  userRoleService;
    }
    @GetMapping("/")
    public ResponseEntity<List<UserRole>>findAll(){
        List<UserRole>allUserRole = userRoleService.findAll();
        return ResponseEntity.ok(allUserRole);
    }
    @PostMapping("/")
    public ResponseEntity<UserRole>createUserRole(@RequestBody UserRoleDto userRoleParam){
        UserRole createdUserRole = userRoleService.create(userRoleParam.toUserRole());
        return ResponseEntity.ok(createdUserRole);
    }
}
