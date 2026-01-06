/* 학습내용
 * 1. 제네릭 문법 이해 및 Wrapper 클래스 활용 연습
 * 2. Wrapper 클래스란? 
 * 	- 기본 타입 8가지를 support해주는 8개의 참조 타입 클래스
 * 	- unboxing: new 생성자 조합 없이도 기본 타입으로 자동으로 반환
 * 	- autoboxing: 참조타입의 변수에 기본값 대입시 자동으로 객체로 변환
 * 	- 예시: ArrayList에 3이라는 값을 저장할 경우 int 불가능, Integer 객체화해서 저장
 * 
 * 3. API 문서 활용에 따른 표현법 이해하기
 * 	- java.util package 내의 자료구조 support용 클래스들
 * 	- Object의 또 다른 표현(jdk 버전업되면서 타입의 명확성을 코드에 부여, 동적 타입 제약)
 * 		- E(element, 요소, 데이터 / html,xml에선 tag 자체를 의미)
 * 		- K(key)
 * 		- V(value)
 * 		- T(type)
 * 
 * 
 */
package step02;

import java.util.ArrayList;

import model.domain.Customer;

public class GenericWrapperTest {
	
	// step01 - wrapper class(autoboxing, unboxing)
	// jdk 1.5부터 지원됨
	static void m1() {
		int i = 10; // 기본 타입
		
//		int i2 = (new Integer(3)).intValue(); 코드와 동일함
		int i2 = new Integer(3); // 기본 타입, unboxing
		
//		Integer i3 = new Integer(30); 코드와 동일
		Integer i3 = 30; // 참조 타입, autoboxing
		
		System.out.println(i + " " + i2);
		System.out.println(i3.toString());
	}
	
	// step02 - Generic 활용(자료구조 class 활용)
	static ArrayList<String> m2() {
		ArrayList al1 = new ArrayList();
		ArrayList<String> al2 = new ArrayList<>();
		ArrayList<Integer> al3 = new ArrayList<>();
		
		al1.add("abc"); //0번째 저장시 Object타입으로 형변환됨(Upcasting)
		al1.add(new Customer("name", 23)); // 1번째 저장
		
		al2.add("이명진"); // 0번째 저장시 String으로 저장
		al2.add("bcd"); // 1번째 저장
		
		/* 
		 * public Object get(int index){}
		 * al1 변수, al2 변수가 참조하는 인덱스 0번째의 문자열 데이터 첫 음절 출력
		 * -
		 */
		System.out.println(((String)al1.get(0)).charAt(0));
		System.out.println(al2.get(0).charAt(0));
		
		return al2;
	}
	
	public static void main(String[] args) {
		// 반환값 설정에도 Generic 선언을 해야 함
		ArrayList<String> al2 = m2();
		System.out.println(al2.get(0).charAt(0));
		
		
//		m1();
		m2();
	}

}
