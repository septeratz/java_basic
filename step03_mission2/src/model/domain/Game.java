package model.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//log 
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {

	public static void main(String[] args) throws IOException {

		// 로그 출력 테스트
		log.info("게임 시작");

		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();

		p1.setName("이유진");
		p2.setName("이명진");
		p3.setName("이승준");
		p4.setName("강민영");

		log.info("유저리스트\n" + p1.getName() + "\n" + p2.getName() + "\n" + p3.getName() + "\n" + p4.getName() + "\n");

		while (true) {
			System.out.println("1~4 사이 수를 입력하시오.끝내려면 0을 누르시오.");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			Person curPerson = null;

			if (n == 1) {
				curPerson = p1;
			} else if (n == 2) {
				curPerson = p2;
			} else if (n == 3) {
				curPerson = p3;
			} else if (n == 4) {
				curPerson = p4;
			} else {
				log.warn("잘못된 입력");
				break;
			}

			log.info("현재 유저: " + curPerson.getName());

			System.out.println("스코어 입력하시오.");
			br = new BufferedReader(new InputStreamReader(System.in));
			int score = Integer.parseInt(br.readLine());
			int cur_score = curPerson.getScore();

			if (score > cur_score) {
				log.info(curPerson.getName() + "님이 기존기록 " + cur_score + "에서 " + score + "로 갱신!");
				curPerson.setScore(score);
			}

			Person[] players = { p1, p2, p3, p4 };

			Arrays.sort(players, (a, b) -> b.getScore() - a.getScore());

			StringBuilder sb = new StringBuilder();
			sb.append("<< 랭킹 >>\n");

			for (int i = 0; i < players.length; i++) {
				sb.append((i + 1) + "위: ").append(players[i].getName()).append(" - ").append(players[i].getScore())
						.append("점\n");
			}

			log.info(sb.toString());

		}
	}
}