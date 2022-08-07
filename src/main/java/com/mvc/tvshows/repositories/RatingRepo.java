package com.mvc.tvshows.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mvc.tvshows.models.Rating;

public interface RatingRepo extends CrudRepository<Rating, Long> {
	List <Rating> findAll();
}
