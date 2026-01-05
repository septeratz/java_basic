package model.domain;


public enum GameType {
	GAME_A("A"),
	GAME_B("B"),
	GAME_C("C"),
	GAME_D("D");
	
	private String name;
	GameType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
