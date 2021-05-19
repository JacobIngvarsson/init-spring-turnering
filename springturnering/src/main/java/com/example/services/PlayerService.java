package com.example.services;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Player;
import com.example.repositories.PlayerInMemoryRepository;
import com.example.requests.AddPlayerRequest;
import com.example.requests.UpdatePlayerRequest;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerInMemoryRepository playerRepo;
	
	
	public Collection<Player> getAll(){
		return playerRepo.getAll();
	}	
	public Player getById(UUID id) {
		return playerRepo.getById(id);
	}	
	public Player addPlayer(AddPlayerRequest request) {
		
		var player = new Player();
		player.setId(UUID.randomUUID());
		player.setFirstName(request.getFirstName());
		player.setLastName(request.getLastName());
		player.setCreatedAt(new Date());
		
		return playerRepo.addPlayer(player);		
	}	
	public Player updatePlayer(UUID id, UpdatePlayerRequest request) {		
		var player = playerRepo.getById(id);		
		player.setLastName(request.getLastName());		
		player.setUpdatedAt(new Date());
		return playerRepo.updatePlayer(id, player);
	}	
	public void deletePlayer(UUID id) {
		playerRepo.deletePlayer(id);
	}
	
}
