/* 
 * 상속 관계: is-a 관계
 * 보유 관계: has-a 관계
 */

package step01;

class A {
	String message = "fisa";
	public A() {
		// super로 부모 생성자 호출
		// string message 객체 생성
		System.out.println("A");
	}
}

class B {
	A a = new A();
	public B() {
		// TODO Auto-generated constructor stub
		System.out.println("B");
	}
}

class C {
	B b = new B();
	public C() {
		// TODO Auto-generated constructor stub
		System.out.println("C");
	}
}


public class ObjectNew {

	public static void main(String[] args) {
		C c = new C(); // 생성되는 객체 순서 및 개수 
		// A 생성 - B 생성 - C 생성
		System.out.println(c.b.a.message);

	}

}
