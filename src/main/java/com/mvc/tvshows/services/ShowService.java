package com.mvc.tvshows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.tvshows.models.Show;
import com.mvc.tvshows.repositories.ShowRepo;


@Service
public class ShowService {
    private final ShowRepo repository;
    
    
    public ShowService(ShowRepo repository) {
		this.repository = repository;
	}
    public List<Show> all() {
        return repository.findAll();
    }
    public Show findBy(Long id) {
        Optional<Show> ShowList = repository.findById(id);
        if(ShowList.isPresent()) {
            return ShowList.get();
        } else {
            return null;
        }
    }
    public void delete(Show show) {
    	repository.delete(show);
    }
    
    public Show save(Show show) {
        return repository.save(show);
    }
}

