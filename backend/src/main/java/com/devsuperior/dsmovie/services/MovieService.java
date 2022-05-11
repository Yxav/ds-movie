package com.devsuperior.dsmovie.services;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);	
		Page<MovieDTO> pagesDTO = result.map(x -> new MovieDTO(x));
		return pagesDTO; 		
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findOne(Long id) {
		Movie result = repository.findById(id).get();	
		MovieDTO movieDTO = new MovieDTO(result);
		return movieDTO; 		
	}
}
