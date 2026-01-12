package view;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import model.domain.DeptDTO;

@Slf4j
public class DeptSuccessView {
	
	// 성공시 단순 메시지 출력
	public static void successView(String message) {
		System.out.println(message);
	}
	
	
	
	public static void allDeptView(ArrayList<DeptDTO> all ) {
		for (DeptDTO dept: all) {
			System.out.println(dept); // 추후 jsp로 브라우저에 table형식으로 출력 예정
			
		}
		log.info("부서 정보 불러오기 성공");
	}

}
