package model.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score {
	private int point;
	
	// 이 기록을 언제 세웠는지 시간 저장
    private LocalDateTime recordDate; 

    // 점수만 넣으면 현재 시간으로 자동 생성해주는 편의용 생성자
    public Score(int point) {
        this.point = point;
        this.recordDate = LocalDateTime.now();
    }
}
