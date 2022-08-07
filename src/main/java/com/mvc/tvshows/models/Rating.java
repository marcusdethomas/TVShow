package com.mvc.tvshows.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="ratings")
public class Rating {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Size(min = 0, max = 10, message = "Title must be at least 3 characters." )
	private String score;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> users;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "shows_ratings", 
        joinColumns = @JoinColumn(name = "rating_id"), 
        inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private List<Show> showRatings;
	
	public Rating() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Show> getShowRatings() {
		return showRatings;
	}

	public void setShowRatings(List<Show> showRatings) {
		this.showRatings = showRatings;
	}
}
