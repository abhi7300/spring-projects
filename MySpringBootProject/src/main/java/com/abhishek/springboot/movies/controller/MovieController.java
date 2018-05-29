package com.abhishek.springboot.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.springboot.movies.orm.Movie;
import com.abhishek.springboot.movies.service.MovieService;


@RestController
@RequestMapping(path="/movies")
public class MovieController {
	
	
	@Autowired
	private MovieService movieService;

	@RequestMapping(path="/getAllMovies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		
		List<Movie> movieList = movieService.getAllMovies();
		
		if(movieList == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(movieList);
	}
	
	

	public MovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}
	
	
	
}
