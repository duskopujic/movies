package com.lanaco.movies.Models;

import com.lanaco.movies.Models.CompositeKeys.UserRoleId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@IdClass(UserRoleId.class)
@Table(name = "user_role",schema = "public")
@Accessors(chain = true)
public class UserRole {
    @Id
    @Column(name = "userId")
    private int userId;
    @Id
    @Column(name = "roleId")
    private int roleId;
}
