package com.lanaco.movies.Configuration;

import com.lanaco.movies.Models.AuthUsersDetails;
import com.lanaco.movies.Models.UserRole;
import com.lanaco.movies.Models.Users;
import com.lanaco.movies.Repository.UserRoleRepository;
import com.lanaco.movies.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersService usersService;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users>users=usersService.findUsersByUsersName(userName);
        users.orElseThrow(()->new UsernameNotFoundException("Nije pronadjen korisnik sa userName-om"+userName));
        List<UserRole>userRoles=userRoleRepository.findByUsers(users.get());

        AuthUsersDetails auth=new AuthUsersDetails(users,userRoles);
        return auth;

    }
}
