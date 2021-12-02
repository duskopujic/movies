package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Role;
import com.lanaco.movies.Models.UserRole;
import com.lanaco.movies.Models.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRoleDto {
    private int usersId;
    private int roleId;


}
