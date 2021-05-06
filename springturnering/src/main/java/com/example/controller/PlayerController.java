package com.example.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.*;

@RestController
@RequestMapping("/api/players/")
public class PlayerController {
		
	Map<Integer, Player> players = new HashMap<Integer, Player>();
	
	
	@GetMapping("/")
	public Collection<Player> getAll(){	
		return players.values();		
	}
	
	
	@GetMapping("/{id}")
	public Player getById(@PathVariable int id) {
		return players.get(id);
	}
	
	@PostMapping("/")  
	public Player addNewPlayer(@RequestBody Player player){
		players.put(player.getId(), player);
		return player;	
	}
	
	@PutMapping("/{id}")
	public Player updatePlayer(@PathVariable int id, @RequestBody Player updatePlayer) {
		
		Player player = players.get(id);
		player.setFirstName(updatePlayer.getFirstName());
		player.setLastName(updatePlayer.getLastName());	
		return player;		
}
	
	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable int id) {
		players.remove(id);
	}
	
}