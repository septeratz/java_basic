/* 정보용 클래스
 * 1. DataTransferObject(DTO)
 * 2. ValueObject(VO)
 * 3. java 시초에 java bean이라고도 표현
 * 4. 클래스명
 *  People.java/PeopleDTO.java
 *  /PeopleVO.java/PeopleBean.java
 *  
 * 5. 구조
 * 	- 데이터 표현(변수) / 활용(수정set, 제공get)
 *	- 변수/생성자/setter메소드/getter메소드
 *	- 권장: 모든 멤버 변수를 하나의 문자열로 가공 후 제공
 *		->toString  	
 * 
 */
package step03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor // 기본 lombok 사용법
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString

// step02: 유연한 멤버 변수 사용에 적합한 사용법
@Getter
@NoArgsConstructor
public class People {
	private String name;
	private int age;
	private String id;
	private String pw;
	// 데이터 수 늘고, 줄고..


}
