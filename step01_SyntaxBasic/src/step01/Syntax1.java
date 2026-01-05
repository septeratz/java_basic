/* 학습 내용
 * - 변수에 대한 학습
 * 1. 선언 위치에 따른 구분
 *  1) 멤버 변수
 *  		- class {} 내부에 선언되는 함수
 *  		- class 기반으로 생성되는 객체의 구성 요소
 *  		- heap 메모리에 생성
 *  		- garbage collector에 의해 객체 관리에 종속됨
 *  	2) 로컬 변수
 *  		- 메소드, 생성자 () 또는 {} 내부에 생성되는 변수 
 *  		- stack 메모리에 생성
 *  		- 생성 시점 : 메소드 또는 생성자 호출 시 생성
 *  		- 소멸 시점 : 메소드 또는 생성자 실행 종료 시 자동 소멸
 * 
 * 2. 타입에 따른 구분
 * 	1) 기본 타입(원시 타입, 값이 하나만 표현되는 타입)
 * 		- jdk 내부에서 제공하는 타입(built in 타입)
 * 		- 8가지만 존재
 * 		- 형태로 구분. 
 * 		문자형(char)/정수형(byte, short, int, long)
 * 		/실수형(float, double)/논리형(boolean)
 * 	2) 참조 타입
 * 		- 기본 타입 외 모든 타입
 * 		- 무한대 개수의 타입
 * 		- 객체 타입(클래스를 기반으로 파생되는 타입)
 * 		- 실제 보유 데이터는 생성된 객체의 주소값
 * 		- print()나 println()으로 출력 시 자동으로 toString()이 호출됨
 * 		즉, 객체 내부에 어떤 데이터를 출력할 것인가에 대한 고려
 * 			원리
 * 			최상위 클래스, 즉 상속 문법 없이도 자동 상속되는 java.lang.Object 클래스가 상속시키는 메소드
 */

package step01;

// 사용자 정의 클래스, 컴파일 후에 Fisa.class와 Syntax1.class 파일이 생성됨
class Fisa{
	public String toString() {
		return "이승준";
	}
}

public class Syntax1 {
	
	// 실행을 위해 특화된 자바 메소드
	public static void main(String[] args) {
		// 기본타입 변수
		int i = 32;
		System.out.println(i);
		// 참조타입 변수
		// 기본 문법: 타입 변수명 = new 생성자();
		Fisa fi = new Fisa();
		System.out.println(fi);
		
		String s = new String("문자열"); // String s = "문자열"; 로 써도 됨
		System.out.println(s.toString()); 
		
	}

}
