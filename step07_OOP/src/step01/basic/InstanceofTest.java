/* 학습내용
 * 1. instanceof 연산자 
 * 	- 객체 타입 비교 연산자
 * 	- 상속 관계 타입끼리만 비교 가능
 * 	- 상속 관계가 아닌 경우 컴파일 자체가 불가능
 * 
 * 동일한 객체 여부 검증: ==
 * 타입만 일치, 서로 다른 객체의 내용값 비교: .equals()
 * 
 * 
 */
package step01.basic;

class A extends Object{}
class B extends A{}
class C extends Object{}

public class InstanceofTest {
	
	public static void main(String[] args) {
		Object v0 = new A();
		A v1 = new A();
		A v2 = new B();
		B v3 = new B();
		
		Object v4 = new C();
		C v5 = new C();
		// == : 참조 타입은 주소값 비교, 기본 타입은 값 비교
		// instanceof: 참조 타입의 타입을 비교
		System.out.println(v0 instanceof Object); // true, 무조건
		System.out.println(v0 instanceof A); // true, A로 생성했으므로 A 포함
		System.out.println(v0 instanceof B); // false, B를 포함하진 않음
		System.out.println(v0 instanceof C); // false, C 포함 X
//		System.out.println(v0 instanceof D); 에러 발생, 존재하지 않는 클래스

		System.out.println(v1 instanceof Object); // true, 무조건
		System.out.println(v1 instanceof A); // true, A이므로 A 포함
		System.out.println(v1 instanceof B); // false, B 포함 X
//		System.out.println(v1 instanceof C); 에러 발생
		
		System.out.println(v2 instanceof Object); // true
		System.out.println(v2 instanceof A); // true
		System.out.println(v2 instanceof B); // true
		
		System.out.println(v3 instanceof Object); // true
		System.out.println(v3 instanceof A); // true
		System.out.println(v3 instanceof B); // true
//		System.out.println(v3 instanceof C); 에러
		
		
		System.out.println(v4 instanceof Object); // true
		System.out.println(v4 instanceof A); // true
		System.out.println(v4 instanceof B); // false
		System.out.println(v4 instanceof C); // false
		
		System.out.println(v5 instanceof Object); // true
//		System.out.println(v5 instanceof A);  에러
//		System.out.println(v5 instanceof B);  에러
		System.out.println(v5 instanceof C); // true
	}
	
}
