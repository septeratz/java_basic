package game.controller;

import java.time.LocalDateTime;
import java.util.List;

import game.model.Database;
import game.model.Model;
import game.model.domain.Player;
import game.view.View;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Controller {
	private final View view = new View();

	public void run() {
		log.info("*** 시스템 시작");
		while (true) {
			int menu = view.showMenu();

			// 1: 접속자 조회, 2: 파티원 추가
			if (menu == 1) {
				log.info("*** 접속자 목록 출력 요청"); // 요구사항 로그
				List<Player> players = Model.getAllPlayers();
				view.printPlayerList(players);
				
				// 온라인 인원 카운트
                long onlineCount = players.stream().filter(Player::isOnline).count();
                log.info("조회 완료 - 온라인 {}명 / 전체 {}명", onlineCount, players.size()); // 요구사항 로그
                
			} else if (menu == 2) {
				log.info("*** 파티원 추가 요청");
				String name = view.inputPlayerName();
				boolean succ = Model.addToParty(name);
				
				if (succ) {
					view.printMessage(">>> 플레이어 추가 성공! ");
					log.info("현재 파티에 '{}'님이 추가되었습니다.", name);
					
					log.debug("[디버그용] 현재 파티원 리스트(배열/인덱스): {}", Model.getMyParty());
				}
				else {
					view.printMessage(">>> 추가 실패(플레이어가 존재하지 않거나 이미 존재하는 파티원입니다)");
					log.warn("파티 추가 실패: {}", name);
				}
			} else {
				System.out.println("시스템 종료");
				log.info("*** 시스템 종료");
				break;
			}

		}
	}

}
