package step05;

import java.util.Arrays;
import java.util.List;

import model.domain.People;

// 미완성 메소드로만 구성된 클래스
// 실제 객체 생성 불가, Type으로 사용 가능, 하위 클래스에서 개발해야만 함

// @FunctionalInterface 람다용으로 사용될 interface 어노테이션, 메소드를 반드시 딱 한개만 써야 함
@FunctionalInterface
interface Calc {
	// 강제적으로 재정의해야 하는 스펙, 연산시에만 활용되는 메소드여야 한단 의미
	public int oper(int v1, int v2); // public abstract int oper(~
}

// 미완성 인터페이스를 완벽하게 구현하는 정통 방식의 자식 클래스 개발
// 단점: +만 계산 가능, - / *는 추가로 또 구현해야 됨
class CalcImpl implements Calc {
	@Override
	public int oper(int v1, int v2) {
		return v1 + v2;
	}
}

public class DoubleTest {
	/*
	 * DoubleTest$1.class - 이름이 없는 클래스에 컴파일 시 자동으로 부여되는 익명 inner class명 - 문법
	 * interface 기준으로 구현 및 객체 생성이 하나의 로직으로 개발
	 * 
	 */

	// step03 - 이름의 존재 여부 확인 후 실행
	// 사전에 부득이하게 구현체 클래스가 없어서 직접 개발 및 객체 생성 코드까지 동시에 해야 함
	public static void main(String[] args) {

		System.out.println("*** step04 ***");
		Calc c = (v1, v2) -> v1 * v2;
		System.out.println(c.oper(10, 20));  // 200
		
		c = (v1, v2) -> v1 / v2;
		System.out.println(c.oper(100, 20)); // 5

		System.out.println("*** step03 ***");
		Calc oper = new Calc() {
			public int oper(int v1, int v2) {
				return v1 + v2;
			}

		};
		Calc oper2 = new Calc() { // DoubleTest$2.class
			public int oper(int v1, int v2) {
				return v1 - v2;
			}

		};
		System.out.println(oper.oper(10, 20)); //100
	}

	// step02
	public static void main2(String[] args) {
		Calc op = new CalcImpl();
		System.out.println(op.oper(2, 8));
	}

	// step01
	public static void main1(String[] args) {
		List<People> datas = Arrays.asList(new People("재석", 50), new People("연아", 30), new People("명진", 27));

		System.out.println("*** step01 : for each");
		for (People p : datas) {
			System.out.println(p);
		}

		System.out.println("*** step02 : 더블 연산자");
		datas.forEach(System.out::println);

		System.out.println("*** step03 : lambda, -> 표기");
		datas.forEach(v -> v.setAge(v.getAge() + 10));
		datas.forEach(v -> System.out.println(v));

		
		

		// People의 이름값만 출력
		datas.forEach(v -> System.out.println(v.getName()));

	}

}
