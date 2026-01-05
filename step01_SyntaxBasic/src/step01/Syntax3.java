package step01;

class A3 {
	String msg = "ce";
}

class B3 {
	 A3 a3 = new A3();
}

class C3 {
	B3 b3 = new B3();
}



public class Syntax3 {

	public static void main(String[] args) {
		C3 c = new C3();
		
		A3 a = c.b3.a3;
		System.out.println(a.msg); // ce
		
		/* 
		 * a 변수 타입 - A3
		 * a.msg 변수 타입 - String (API)
		 *  - 기능: 숫자로 글자 선별해서 한 글자만 출력
		 *  - 필요 정보: index값 주고 char값 받음
		 *     index값(parameter) 주고 char값 받음(return)
		 *     
		 *     public char ? (int index) {
		 *     		return msg[index];
		 *     }
		 */
		
		char data = a.msg.charAt(0);
		System.out.println(data); // c
	}

}
