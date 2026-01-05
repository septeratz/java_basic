package step03;

public class PeopleTest {

	public static void main(String[] args) {
		/* People.buider().id("User01").build()
		 * - People.builder()
		 * 	: static 메소드, 클래스명으로 호출 가능
		 * 	: 반환값이 PeopleBuilder 객체
		 * - People.builder.id("User01")
		 * 		: PeopleBuilder 클래스 내부에서 id 변수값 수정하는 메소드
		 * 		: non-static 메소드, PeopleBuilder 객체 통해서만 호출 가능
		 * 		: People.builder() 반환값이 PeopleBuilder 객체
		 * - People.builder().id("User01").build()
		 * 	: PeopleBuilder 내부에 제공되는 메소드
		 * 	: People 객체 반환
		 * 
		 * 
		 */
		
		
		// user01이라는 id만 초기화된 People객체 생성
//		People p1 = People.builder().id("user01").build();
//		System.out.println(p1.getId());
//		
//		People p2 = People.builder().id("user02").pw("22").build();
		
		
	}

}
