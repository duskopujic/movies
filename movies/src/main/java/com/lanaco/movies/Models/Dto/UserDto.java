package com.lanaco.movies.Models.Dto;


import com.lanaco.movies.Models.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    private Integer userId;
    private String userName;
    private String firstName;
    private  String lastName;
    private String adress;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Integer> roleIds;

    public Users toUsers(){
        return new Users()
                .setUserName(userName)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAdress(adress)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setPassword(password);

    }
}
