package game.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import game.model.domain.Player;

public class Database {
	private static List<Player> players = new ArrayList<>();
	private static List<Player> myParty = new ArrayList<>();
	private Database() {};
	
	static {
		players.add(new Player("A", false, LocalDateTime.now().minusDays(1)));
		players.add(new Player("B", true, LocalDateTime.now()));
		players.add(new Player("C", true, LocalDateTime.now().minusHours(1)));
		players.add(new Player("D", false, LocalDateTime.now().minusDays(5)));
		
	}
	
	public static List<Player> getAllPlayers() {
		return players;
	}
	
	public static boolean addToParty(String newName) {
		// 이미 존재하는 플레이어인지 확인
		Player target = null;
		for (Player input: players) {
			if (input.getName().equals(newName)) {
				target = input;
				break;
			}
		}
		// 존재하지 않는 플레이어의 경우 실패
		if (target == null) return false;
		
		// 이미 파티에 존재하는 플레이어의 경우 실패
		if (myParty.contains(target)) return false;
		
		myParty.add(target);
		return true;
		
	}

	// (디버깅용) 파티 목록 전체 반환
    public static List<Player> getMyParty() {
        return myParty;
    }
}
