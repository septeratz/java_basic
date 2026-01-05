package lab01;

//열거형 정의
enum ProcessStatus {
	STARTED, COMPLETED, FAILED, HALT
}

public class EnumProcessTest {

	public static void main(String[] args) {
		// 1. 정상적인 할당
		ProcessStatus status = ProcessStatus.STARTED;
		System.out.println("Current status: " + status);

		// 2. 컴파일 에러 발생 예시
//      status = "Started";  // Error: Type mismatch (String cannot be converted to ProcessStatus)
		// status = 100; // Error: Type mismatch (int cannot be converted to
		// ProcessStatus)

		// 3. 조건문 활용
		if (status == ProcessStatus.STARTED) {
			System.out.println("프로세스가 시작되었습니다.");
		}

		System.out.println(ProcessStatus.values());
		System.out.println(ProcessStatus.values()[0]);
		/* 
		 * ProcessStatus.values()[0] : STARTED
		 * 여기서 나온 STARTED는 클래스인가? O
		 * STARTED: getter, setter 사용 가능
		 */
		System.out.println(ProcessStatus.values()[0].toString());
		System.out.println(ProcessStatus.values()[0].getClass());
		/* 
		 * ProcessStatus.values()[0].name()
		 * 
		 */
		System.out.println(ProcessStatus.values()[0].name());
		
		
	}
}

/*
 * enum은 클래스 형태로 상수를 사용하기 위해 사용하는 자료형. 
 * 상수임에도 숫자로 시작하면 안됨(문자로 시작해야 함), 대문자 여부는 상관없음, 선언 시 컴마만 사용(세미콜론 x) 
 * 상수 형태이므로 값 변환 불가
 * 
 */