package com.lanaco.movies.Models;

import com.lanaco.movies.Models.CompositeKeys.UserRoleId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_role",schema = "public")
@Accessors(chain = true)
public class UserRole {

    @EmbeddedId
    @Column(name = "user_role_id")
    private UserRoleId userRoleId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;
}
