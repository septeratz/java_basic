// RDBMS 데이터베이스와 흡사한 기능의 클래스라 가정
// static {} 실행 시점: byte code가 메모리에 저장 시 단 한번 자동 실행
package model;

import model.domain.Customer;

public class Database {
	// 데이터 보관: 24시간 365일 실행시 단 한번만 초기화, 반환
	private static Customer [] allCusts = new Customer[4];
	private Database() {}
	
	// 보관
	static {
		allCusts[0] = new Customer("user01", 11, "개발자");
		allCusts[1] = new Customer("user02", 22, "기획자");
		allCusts[2] = new Customer("user03", 33, "운영자");
	}
	
	
	// 반환: select * from customer;
	public static Customer[] getCustomers(){
		return allCusts;
	}
	
	// 가입: insert into customer values ("user04", 44, "연구원");
	// id, pw, job
	public static boolean insertCustomer(Customer newCust) {
		allCusts[3] = newCust;
		return true;
		
	}

}
