package com.padillatomas.mundo_disney.disney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.mundo_disney.disney.dto.MovieBasicDTO;
import com.padillatomas.mundo_disney.disney.dto.MovieDTO;
import com.padillatomas.mundo_disney.disney.service.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {

	// === Instanciamos SERVICE ===
	@Autowired
	private MovieService movieServ;
		
			
	// == GET ==
	@GetMapping
	public ResponseEntity<List<MovieBasicDTO>> getBasicMovies(){
		List<MovieBasicDTO> movies = movieServ.getBasicMoviesList();
		return ResponseEntity.status(HttpStatus.OK).body(movies);
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<MovieDTO> getDetailsById(@PathVariable Long id){
		MovieDTO movie = movieServ.getMovieDetails(id);
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}
	
	// == POST ==	
	@PostMapping
	public ResponseEntity<MovieDTO> postNewMovie(@RequestBody MovieDTO newMovie){
		MovieDTO createdMovie = movieServ.saveNewMovie(newMovie);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(createdMovie);
	}
	
	// == PUT ==		
	// == DELETE ==		
}
