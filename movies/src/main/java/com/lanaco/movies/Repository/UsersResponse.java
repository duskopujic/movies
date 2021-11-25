package com.lanaco.movies.Repository;

import lombok.Data;

@Data
public class UsersResponse {
    private int userId;
    private String userName;
    private String firstName;
    private  String lastName;
    private String adress;
    private String phoneNumber;
    private String email;
    private String password;


}
