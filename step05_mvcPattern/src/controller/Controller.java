/* client -> 화면(StartView.java) -> Controller가 요청을 구분함 -> Model
 * -> Controller로 응답 -> view.EndAllView.java 정상 실행값 출력
 * 					  -> EndInsertSuccessView.java
 * 
 */
package controller;

import model.Model;
import model.domain.Customer;
import view.EndAllView;
import view.EndFailView;
import view.EndInsertSuccessView;

public class Controller {

	// 1 - 검색, 2 - 가입
	public static void reqProcess(int reqNo) {
		if (reqNo == 1) { // 모든 검색
//			Customer[] all = Model.getAllCustomer();
//			EndAllView.printAll(all); // 출력 전담 클래스의 메소드 호출
			
			EndAllView.printAll(Model.getAllCustomer()); 

		} else if (reqNo == 2) { // 가입, 가입 정보도 함께 서버로 전송되었다 가정
			EndInsertSuccessView.successMessage(Model.insertCust(new Customer("User05", 55, "연구원")));
		} else { // 미존재하는 로직 요청시 처리 블락
			EndFailView.print("요청이 무효합니다, 재확인 부탁");

		}
	}

}
