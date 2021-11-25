package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{
    List<Users>findAllByUserIdGreaterThanOrderByUserIdDesc(int id);
}




