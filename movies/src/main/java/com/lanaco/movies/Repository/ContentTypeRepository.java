package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentTypeRepository extends JpaRepository<ContentType, Integer> {


}
