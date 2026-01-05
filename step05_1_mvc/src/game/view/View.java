package game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import game.model.domain.Player;

public class View {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int showMenu() {
		System.out.println("== 파티 관리 시스템 ==");
		System.out.println("1. 접속자 조회, 2. 파티 추가, 이외 입력: 종료");
		System.out.print("명령 선택 > ");
		try {
			String input = br.readLine();
			return Integer.parseInt(input);
			
		} catch (IOException | NumberFormatException e) {
			return 0;
			
		}
		
	}
	
	public String inputPlayerName() {
		System.out.print("입력할 플레이어 이름: ");
		try {
            // 한 줄 통째로 읽기
            return br.readLine();
        } catch (IOException e) {
            return ""; // 에러 나면 빈 문자열 반환
        }
		
	}
	
	public void printPlayerList(List<Player> players) {
		System.out.println("현재 접속중인 플레이어 목록: ");
		for (Player input: players) {
			System.out.println(input.getName() + "님이 " + input.getStatusString());
		}
	}
	
	public void printMessage(String msg) {
        System.out.println(msg);
    }
}
