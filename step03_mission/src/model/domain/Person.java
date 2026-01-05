package model.domain;

import java.util.HashMap;
import java.util.Map;


import lombok.Data;

@Data
public class Person {
	private String name;
	private Map<GameType, Score> bestScores = new HashMap<>();
	
	public Person(String name) {
		this.name = name;
	}
	public int updateScore(GameType game, int newPoint) {
		// 기존 기록 불러오기 (없으면 0점짜리 불러옴)
		Score oldScore = bestScores.getOrDefault(game, new Score(0));
		
		// 비교 로직
		if (newPoint > oldScore.getPoint()) {
			// 차이 구한 뒤 새로 업데이트
			int diff = newPoint - oldScore.getPoint();
			bestScores.put(game, new Score(newPoint));
			// 차이값 리턴
			return diff;
			
		}
		return 0; // 갱신 실패
		
	}
}
