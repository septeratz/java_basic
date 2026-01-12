package view;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeptFailView {

	// 예외 메세지 다 출력 가능한, 재사용 고려한 화면 처리 로직의 메소드
	// 추후: HTML 또는 jsp로 변환 예정
	public static void printMsg(String message) {
		System.out.println(message);
		log.error("발생된 이슈 : ", message);
	}

}
