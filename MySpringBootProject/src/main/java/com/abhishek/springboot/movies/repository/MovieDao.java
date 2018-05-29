package com.abhishek.springboot.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.springboot.movies.orm.Movie;

@Repository(value="movieDao")
public interface MovieDao extends JpaRepository<Movie,Long>{

	/*public List<Movie> getAllMovies();*/
	
}
