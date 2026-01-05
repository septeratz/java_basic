/* 브라우저에 모든 고객 정보를 table 형식으로 보기좋게 출력하는 정상 소스파일이라 가정
 * 
 */
package view;

import model.domain.Customer;

public class EndAllView {
	// 배열 데이터값 반복 통해서 출력 = for each 반복문
	public static void printAll(Customer[] allCustomer) {
		for (Customer cust : allCustomer) {
			System.out.println(cust); // cust.toString()과 같음
		}
		
	}

}
