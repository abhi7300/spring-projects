package com.abhishek.springboot.movies.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.springboot.movies.orm.Movie;
import com.abhishek.springboot.movies.repository.MovieDao;
import com.abhishek.springboot.movies.service.MovieService;

@Service(value = "movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	@Override
	public List<Movie> getAllMovies() {
		
		Iterable<Movie> movieIterable = movieDao.findAll();
		List<Movie> movieList = new ArrayList<>();

		movieIterable.forEach(movieList::add);
		
		return movieList;
		
	}

	public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

}
