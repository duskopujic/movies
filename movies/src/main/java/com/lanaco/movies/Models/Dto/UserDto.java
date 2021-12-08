package com.lanaco.movies.Models.Dto;


import com.lanaco.movies.Models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;




@Data
@AllArgsConstructor
public class UserDto {


    private Integer userId;
    private String userName;
    private String firstName;
    private  String lastName;
    private String adress;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Integer> roleId;

}
