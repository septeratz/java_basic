package step02;

import java.util.ArrayList;
import java.util.HashMap;

import model.domain.Customer;

public class ReferenceTest {

	public static void main(String[] args) {
		HashMap<String, Customer> datas = new HashMap<>();
		datas.put("u1", new Customer("id1", 1));
		datas.put("u2", new Customer("id2", 2));
		datas.put("u3", new Customer("id3", 3));
		
		HashMap<String, HashMap<String, Customer>> datas2 = new HashMap<>();
		datas2.put("u11", datas);
		
		ArrayList<HashMap<String, HashMap<String, Customer>>> datas3 
		= new ArrayList<>();
		
		datas3.add(datas2);
		
		//? new Customer("id1", 1) 객체의 데이터값을 toString() 출력
		System.out.println(datas3.get(0).get("u11").get("u1"));
		
		//? new Customer("id2", 2) 의 age값을 23으로 변경
		datas3.get(0).get("u11").get("u2").setAge(23);
		System.out.println(datas3.get(0).get("u11").get("u2"));
		
		
		//? u3 key로 매핑된 데이터를 null로 초기화 해 주세요
		System.out.println(datas3.get(0).get("u11").get("u3"));
		datas3.get(0).get("u11").put("u3", null);
		System.out.println(datas3.get(0).get("u11").get("u3"));
		
		
		
		
	}

}