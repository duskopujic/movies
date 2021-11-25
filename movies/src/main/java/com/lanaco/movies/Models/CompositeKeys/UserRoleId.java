package com.lanaco.movies.Models.CompositeKeys;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class UserRoleId implements Serializable {
    private int userId;
    private int roleId;

    public UserRoleId(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
