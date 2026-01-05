/* 생성자 개발 및 호출 문법
 * static 멤버 변수와 instance 멤버 변수
 * 
 * 
 */

package step02;

/* 
 * jvm 메모리
 * 1. method 영역 - byte code 저장
 * 2. stack 영역
 * 3. heap 영역 - 객체들만 저장, garbage collector 관리 하
 */

public class Syntax1 {
	/* 
	 * no1이 실제 메모리에 32bit를 확보 및 생성하는 시점?
	 * 어디에 저장?
	 * no2는 객체 생성이 필수적이고, heap에 생성됨 
	 * static{}
	 *  - 단 한번만 실행되는 특수 블록
	 *  - 공유자원 당 1회성으로 초기화 로직에 적합. 
	 *  - 언제 실행?
	 */
	
	// static 변수
	static int no1; // 0 값으로 자동 초기화
	
	// instance 변수
	int no2;
	
	public Syntax1() {
		no1++;
		no2++;
	}
	
	static {
		System.out.println(11);
	}
	
	void m1() {
		System.out.println("instance 메소드");
	}
	
	static String m2(String data) {
		
		return "문자열 반환 " + data;
	}
	
	public static void main(String[] args) {
		Syntax1 s1 = new Syntax1();
		Syntax1 s2 = new Syntax1();
		System.out.println(no1 + " " + s1.no2);
		System.out.println(no1 + " " + s2.no2);
		System.out.println(s1.no1 + " " + s2.no2);
		System.out.println(Syntax1.no1 + " " + s2.no2);
		
		/* 
		 * main 호출 시점엔 객체 생성과 무관하게 사용 가능: static
		 * 객체 생성이 없다면 instance 변수와 메소드는 사용할 수 없음
		 */
		
		s1.m1();
		System.out.println(m2("ㅣㅇ며진"));
		
		System.out.println(s1); 
		System.out.println(no1); // 객체 생성과 무관하게 호출 및 실행
		System.out.println(s1.no2); // 객체가 존재해야 호출 가능함. no2만 호출하면 사용 불가
		
		
	}

}

/* 참조 타입 변수명으로 출력 시 toString() 자동 호출
 * 기능: 생성된 객체의 이름 및 메모리 위치값을 문자열로 조합해서 반환
 * 재정의로 내용 수정 가능
 * 
 * 컴파일 명령어: *.java -> *.class
 * > javac Syntax1.java
 * 실행 명령어: *.class 파일로 실행 
 * > java Syntax1
 * -> Syntax1.main(); 호출
 * 
 */
