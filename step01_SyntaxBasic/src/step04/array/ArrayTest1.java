/* 학습내용
 * 1. 하나의 변수로 다수의 데이터를 고유한 index로 구분하면서 관리 및 활용
 * 2. index 시작은 0
 * 3. 데이터 타입 - 기본타입/참조타입
 * 4. 모든 배열은 객체 타입
 * 		- 생성되는 메모리는 heap에 존재
 * 		- 각 index로 구분되는 영역은 기본값으로 자동 초기화
 * 5. 자동 생성되는 속성(변수) - length
 * 6. index로 관리되는 데이터와 length 데이터
 * 	- 호출 방법
 * 7. 주의사항
 * 	- 객체 생성시 new 생성자() 문법 필수
 * 	- 예외: String과 배열은 표현법만으로 실행시 자동으로 객체가 생성됨
 * 		String "" / 배열 {값1, 값2, ... }
 * 		그 이외 모든 객체들은 new 생성자 호출 필수
 */

package step04.array;

import org.junit.Test;

import step03.People;

public class ArrayTest1 {

	// 기본 타입인 int 배열
	@Test
	public void m1() {
		int i = 3; // 기본타입
		// 3개의 메모리 보유한 int배열 객체 생성
		// 이후 자동 초기화
		int[] i2 = new int[3]; // 참조타입
		i2[0] = 3;
		System.out.println(i2[0] + " " + i2[1] + " " + i2.length);

	}

	// String 타입 배열
	@Test
	public void m2() {
		String[] data = { new String("a"), "b", "c" };
		System.out.println(data[0]);
	}

	// 사용자 정의 타입 배열
	@Test
	public void m3() {
		People[] data = { new People(), new People(), new People() };
		System.out.println(data[1]); // data[1].toString()과 값이 같음
	}

}
