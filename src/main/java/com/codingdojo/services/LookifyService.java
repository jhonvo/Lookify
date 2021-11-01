package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Lookify;
import com.codingdojo.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	private final LookifyRepository LookifyRep;
	
	public LookifyService(LookifyRepository LookifyRep) {
		this.LookifyRep = LookifyRep;
	}
	
	public List<Lookify> allSongs(){
		return LookifyRep.findAllByOrderByCreatedAtDesc();
	}
	
	public List<Lookify> topTenSongs(){
		return LookifyRep.findTop10ByOrderByRatingDesc();
	}
	
	public Lookify getSong(Long id) {
		Optional<Lookify> song = LookifyRep.findById(id);
		if(song.isPresent()) {
            return song.get();
        } else {
            return null;
        }
	}
	
	public List<Lookify> songsByArtist(String artist){
		return LookifyRep.findByArtistContaining(artist);
	}
	
	public Lookify createSong (Lookify song) {
		return LookifyRep.save(song);
	}
	
	public Lookify updateSong (Lookify song) {
		return LookifyRep.save(song);
	}
	
	public void deleteSong(Long id) {
		LookifyRep.deleteById(id);
	}
	

}
