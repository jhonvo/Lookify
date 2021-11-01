package com.codingdojo.repositories;

import java.util.List;

//import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	
	List<Lookify> findAllByOrderByCreatedAtDesc();
	
	List<Lookify> findTop10ByOrderByRatingDesc();
	
	List<Lookify> findByArtistContaining(String artist);
	
}
