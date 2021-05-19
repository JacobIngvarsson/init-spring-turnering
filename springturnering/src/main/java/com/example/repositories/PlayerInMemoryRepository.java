package com.example.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.entities.Player;

@Service
public class PlayerInMemoryRepository {
	
	Map<UUID, Player> players = new HashMap<UUID, Player>();
	
	
	
	public Collection<Player> getAll() {		
		return players.values();		
	}
	
	
	public Player getById(UUID id) {
		return players.get(id);
	}

	public Player addPlayer(Player player) {
		players.put(player.getId(), player);
		return players.get(player.getId());
	}
	
	public Player updatePlayer(UUID id, Player player) {
		players.put(id, player);
		return players.get(id);
	}
	
	public void deletePlayer(UUID id) {
		players.remove(id);
		
	}
	
}
