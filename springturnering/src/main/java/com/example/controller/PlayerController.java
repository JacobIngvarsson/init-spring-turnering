package com.example.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.*;
import com.example.requests.AddPlayerRequest;
import com.example.requests.UpdatePlayerRequest;
import com.example.services.PlayerService;

@RestController
@RequestMapping("/api/players/")
public class PlayerController {
	
	
	
	@Autowired
	private PlayerService playerService;
		
	
	@GetMapping("/")
	public Collection<Player> getAll(){	
		return playerService.getAll();		
	}
	
	
	@GetMapping("/{id}")
	public Player getById(@PathVariable UUID id) {
		return playerService.getById(id);
	}
	
	@PostMapping("/")  
	public Player addNewPlayer(@RequestBody AddPlayerRequest request) {
		return playerService.addPlayer(request);	
	}
	
	@PutMapping("/{id}")
	public Player updatePlayer(@PathVariable UUID id, @RequestBody UpdatePlayerRequest request) {
		return playerService.updatePlayer(id, request);		
}
	
	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable UUID id) {
		playerService.deletePlayer(id);
	}
	
}