package game.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {
	private String name;
	private boolean isOnline;
	private LocalDateTime lastLogin;
	
	public String getStatusString() {
        if (isOnline) {
            return "ONLINE";
        } else {
            // 날짜를 예쁘게 포맷팅 (yyyy-MM-dd HH:mm)
            String timeStr = lastLogin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            return "OFFLINE (마지막 접속: " + timeStr + ")";
        }
    }
	
}
