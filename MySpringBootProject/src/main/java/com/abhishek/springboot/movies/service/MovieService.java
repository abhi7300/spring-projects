package com.abhishek.springboot.movies.service;

import java.util.List;

import com.abhishek.springboot.movies.orm.Movie;

public interface MovieService {

	public List<Movie> getAllMovies();
	
}
