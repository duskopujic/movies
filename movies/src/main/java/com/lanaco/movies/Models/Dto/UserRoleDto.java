package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRoleDto {
    private int usersId;
    private int roleId;

public UserRole toUserRole() {
    return new UserRole()
            .setUserId(usersId)
            .setRoleId(roleId);
}
}
