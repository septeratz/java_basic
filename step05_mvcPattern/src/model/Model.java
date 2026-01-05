/* biz 요청 처리 핵심 클래스
 * Controller -> Model -> Controller
 * 
 * Model 관점에서 Database 객체 생성 없이 필요한 메소드 기능만 호출
 * 데이터 검색 시 출력은 Controller에 위임시
 */

package model;

import model.domain.Customer;

public class Model {
	// 1 입력 시 실행되는 biz 메소드
	// 모든 고객 정보 검색 메소드
	// 추후 예외처리 학습 후 null반환 또는 배열 반환에 따른 값 분기
	public static Customer[] getAllCustomer() {
		return Database.getCustomers();
	}
	
	// 2 입력되면 실행되는 biz 메소드
	// 고객 가입
	// 실제 insert하는 코드로 변환됨
	public static boolean insertCust(Customer cust) {
		return Database.insertCustomer(cust);
	}

}
