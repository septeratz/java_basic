/* 학습 내용
 * - 변수에 대한 학습
 * 1. 선언 위치에 따른 구분
 *  1) 멤버 변수
 *  		- class {} 내부에 선언되는 함수
 *  		- class 기반으로 생성되는 객체의 구성 요소
 *  		- 객체 생성시 기본 데이터값으로 자동 초기화됨
 *  			정수: 0, 실수: 0.0, char: null('\u0000'), 논리: false
 *  			참조타입은 참조하는 객체가 없다는 뜻으로 null 값으로 자동으로 초기화됨
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
 * 3. 변수 문법
 * 	타입 변수명; - 선언만
 * 	타입 변수명 = 값; - 선언 및 초기화
 * 
 * * 객체 지향의 장점
 * 	 - 데이터를 포함한 구분이 명확함
 * 	 - 데이터 구분을 위해선 객체 생성을 권장함 
 * 	 - 메소드들(기능들)로만 구성된 클래스 기반의 객체 생성은 하나만 생성해서 공유하거나 객체 생성 없이 메소드만 작성
 */

package step01;

class Car extends Object{
	String carName; // 참조 타입 멤버 변수
}

class Person extends Object{ // 데이터 표현 클래스, Data Transfer Object(DTO)
	Car car; // 참조 타입의 멤버 변수 - 객체의 주소값
	int age; // 기본 타입의 멤버 변수 - 원시값
	// 부모 생성자를 호출함
	
}

class Fisa2{
	int i; // 멤버 변수, 객체 생성시 자동 생성, heap 메모리
	Person p = new Person();
}


public class Syntax2 {
	
	public static void main(String[] args) {
		// Fisa2 객체 2개 생성, Car 객체 생성 
		Fisa2 a = new Fisa2();
		Fisa2 b = new Fisa2();
		Car k = new Car();
		// Car 객체 내 멤버 변수 설정
		k.carName = "sonata";
		// a와 b 내부의 p(Person)의 car 변수를 미리 만들어놓은 객체로 설정
		a.p.car = b.p.car = k;
		// 둘이 똑같이 나옴
		System.out.println(a.p.car.carName);
		System.out.println(b.p.car.carName);
		System.out.println(a.p.car == b.p.car);

		/* == : 동등 비교 연산자
		 * 1. 기본 타입 - 순수 원시 데이터값 비교
		 * 2. 참조 타입 - 주소값 비교
		 */
		
		Fisa2 fi = new Fisa2(); // 생성된 객체는 i라는 변수 공간을 이미 확보한 상태
		Fisa2 fi2 = new Fisa2();
		fi2.i = 100;
		System.out.println(fi.i);
		fi.i = fi2.i;
		System.out.println(fi.i);
		
		System.out.println(fi == fi2);
		

		
	}

}
