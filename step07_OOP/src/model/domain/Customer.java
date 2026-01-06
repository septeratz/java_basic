package model.domain;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends Object{
	String name;	// 참조 타입, null
	int age;		// 기본 타입, 0
	
	// 재정의 - 서로 다른 Customer 객체의 데이터값 비교
	/* 타입이 Customer로 일치될 경우 name 변수값과 age 변수값 비교
	 * 타입 비교 시 instanceof
	 * name 변수값 비교 시 String 클래스 내에 비교하도록 재정의된 메소드 존재
	 * 	public boolean equals(Object v) {}
	 * age 변수값 비교: ==
	 * 
	 * name, age 변수는 Customer, 즉 Object 자식 내에만 존재
	 * 즉 Object로 변수 참조 불가능
	 * 해결책: 참조 타입 형변환(상속 관계에서만 부모 레벨을 자식 레벨로 변환) 
	 */
	
	@Override
	public boolean equals(Object v) {
		if (v instanceof Customer) {
			Customer c = (Customer)v;
			if (name.equals(c.name) && age == c.age) return true;
		}
		return false;
	}
	
	
}

