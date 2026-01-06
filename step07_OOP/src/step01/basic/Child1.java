/* 학습 내용
 * 1. 상속 이해하기
 * 	- 변수, 메소드를 자식에게 상속
 * 	- static{}과 생성자는 상속 불가
 * 	- 장점: 코드의 재사용성이 극대화됨
 * 	- 단점: 실행 속도 저하 요인이 될 수 있음
 * 
 * 2. 주요 용어
 * 	1) 재정의 (overriding) 
 * 		- 상속 관계에서 자식이 상속받은 메소드의 내용만 수정
 * 	2) 다중정의 (overloading)
 * 		- 동일 클래스 내에서 동일한 이름의 다수 메소드 개발
 * 		- parameter가 다른 생성자를 여러 개 쓰는 것도 다중정의
 * 
 * 
 */

package step01.basic;


class Parent1 extends Object {
	String id;
	int age;
	
	public Parent1() {
		super();
	}
	
	void printAll() {
		System.out.println(id);
		System.out.println(age);
	}
}

public class Child1 extends Parent1 {
	String job;
	
	//재정의 문법: 반환타입, 메소드명, argument는 100% 같아야 함
	void printAll() {
		super.printAll(); // 상속받은 부모 메소드 모두 적용
		System.out.println(job);
	}
	


	public Child1() {
		super();
	}
	
	public static void main(String[] args) {
		Child1 c1 = new Child1(); // id, age, job
		c1.id = "user01";
		System.out.println(c1.id);
		c1.job = "DevOps";
		c1.printAll(); // 수정 없이 상속만 받은 상태
		
		Parent1 p7 = new Child1();
		p7.id = "ce";
		Child1 c7 = (Child1)p7;
		c7.job = "rob";
		
		System.out.println("*** " + c7.id);
		c7.id = "fisa";
		System.out.println("*** " + p7.id);

		// 다형성 - 학습용 코드(job 변수까지 활용할 경우 다형성 객체 생성 문법 비추천)
		/* 다형성
		 * 상위타입의 변수는 모든 자손 수용
		 * 자손은 조상이다(is a)
		 * 
		 */
		Object o = new Object();
		Object o1 = new Parent1();
		Object o2 = new Child1();
		
		Parent1 p = new Parent1();
		Parent1 p1 = new Child1();
		
		
	}

}


