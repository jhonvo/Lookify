package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.models.Lookify;
import com.codingdojo.services.LookifyService;

@Controller
public class LookifyController {
	
	private final LookifyService lookifySer;
	
	public LookifyController(LookifyService lookifySer) {
		this.lookifySer = lookifySer;
	}

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lookify> songs = lookifySer.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam (value="artist") String artist) {
		if (artist == "") {
			return "redirect:/dashboard";
		}
		else{
			String searchurl = "redirect:/search/" + artist;
			return searchurl;
		}
		
	}

	@RequestMapping("/search/{artist}")
	public String searchArtist(Model model, @PathVariable("artist") String artist) {
		List<Lookify> songs = lookifySer.songsByArtist(artist);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Lookify> songs = lookifySer.topTenSongs();
		model.addAttribute("songs", songs);
		return "top.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String song(Model model, @PathVariable("id") Long id) {
		Lookify song = lookifySer.getSong(id);
		model.addAttribute("song", song);
		return "song.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String songNew(@ModelAttribute("song") Lookify song) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String songSave(@Valid @ModelAttribute("song") Lookify song,BindingResult result) {
		if (result.hasErrors()) {
            return "new.jsp";
        } else {
            lookifySer.createSong(song);
            return "redirect:/dashboard";
        }
	}
	
	@RequestMapping("/songs/edit/{id}")
	public String songEdit(@ModelAttribute("song") Lookify song, @PathVariable("id") Long id, Model model) {
		Lookify target = lookifySer.getSong(id);
		model.addAttribute("song", target);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/songs/edit/{id}", method=RequestMethod.PUT)
	public String songUpdate(@Valid @ModelAttribute("song") Lookify song,BindingResult result) {
		if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            lookifySer.updateSong(song);
            return "redirect:/dashboard";
        }
	}
	
	@RequestMapping("/songs/remove/{id}")
    public String destroy(@PathVariable("id") Long id) {
		lookifySer.deleteSong(id);
		return "redirect:/dashboard";
    }
	
	
}
