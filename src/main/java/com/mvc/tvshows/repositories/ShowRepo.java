package com.mvc.tvshows.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.tvshows.models.Show;

@Repository
public interface ShowRepo extends CrudRepository<Show, Long>{
	List<Show> findAll();
}

