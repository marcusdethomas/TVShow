package com.mvc.tvshows.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.tvshows.models.Rating;
import com.mvc.tvshows.repositories.RatingRepo;




@Service
public class RatingService {
	private final RatingRepo repository;
	  public RatingService(RatingRepo repository) {
			this.repository = repository;
		}
	    public List<Rating> all() {
	        return repository.findAll();
	    }
}
