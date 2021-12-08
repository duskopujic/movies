package com.lanaco.movies.Controllers;

import com.lanaco.movies.Models.Dto.RoleDto;
import com.lanaco.movies.Models.Role;
import com.lanaco.movies.Services.RoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService=roleService;
    }
    @GetMapping("/all")

    public ResponseEntity<List<Role>>findAllRole(){
        List<Role>allRole=roleService.findAll();
        return ResponseEntity.ok(allRole);
    }
    @GetMapping("")

    public ResponseEntity<Role>getOneRole(@RequestParam("id")int id) {
        Optional<Role> optionalRole = roleService.findOneById(id);
        if (optionalRole.isPresent())
        {
            return ResponseEntity.ok(optionalRole.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/save")

    public ResponseEntity<Role>createRole(@RequestBody RoleDto roleParam){
        Role createdRole = roleService.create(roleParam.toRole());
        return ResponseEntity.ok(createdRole);
    }
    @PutMapping("/update")

    public ResponseEntity<Role>updateRole(@RequestParam("id")int id,
                                          @RequestParam("name")String name)
    {
        Optional<Role> optionalRole = roleService.findOneById(id);
        if(optionalRole.isPresent())
        {
            Role role = optionalRole.get();
            role.setName(name);
            return ResponseEntity.ok(optionalRole.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete")

    public void deleteRole(@RequestParam("id")int id)
    {
    roleService.deleteById(id);
    }
}
