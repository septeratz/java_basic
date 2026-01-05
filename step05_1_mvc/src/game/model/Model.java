package game.model;

import java.util.List;

import game.model.domain.Player;

public class Model {
	public static List<Player> getAllPlayers() {
		return Database.getAllPlayers();
	}
	
	public static boolean addToParty(String newName) {
		return Database.addToParty(newName);
	}
	
	public static List<Player> getMyParty() {
		return Database.getMyParty();
	}
}
