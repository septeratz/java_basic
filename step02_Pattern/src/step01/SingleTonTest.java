//java SingleTonTest
package step01;

//single ton 
class SingleTonBiz{
	//공통 기능의 상태값(데이터 존재한다 가정)
	static SingleTonBiz instance = new SingleTonBiz();
	private SingleTonBiz() {}
	public static SingleTonBiz getInstance() {
		return instance;
	}
	//다양한 biz로직의 메소드들 존재, 단 non-static(instance 메소드)
	public String biz1() {
		//상태 관리 기능 ...
		return "biz 로직 메소드";
	}	
}

public class SingleTonTest {

	public static void main(String [] args) {
		// instance 변수 선언 및 SingleTonBiz의 메소드를 호출하여 값을 대입하는 방식.
		// 이미 생성된 객체의 주소값을 공유하기 때문에 이후에 받아서 사용해도 계속 변경되어 있음
		SingleTonBiz instance = SingleTonBiz.getInstance(); // SingleTonTest 로컬 변수 선언
		SingleTonBiz.instance = null; // SingleTonBiz의 멤버 변수
		System.out.println(instance.biz1());
		SingleTonBiz ins = SingleTonBiz.getInstance();
		System.out.println(ins.biz1());
	}
	
	
}