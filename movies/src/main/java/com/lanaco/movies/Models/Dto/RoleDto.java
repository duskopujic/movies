package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
public class RoleDto {
    public String name;
public Role toRole(){
        return new Role()
                .setName(name);
}

}
