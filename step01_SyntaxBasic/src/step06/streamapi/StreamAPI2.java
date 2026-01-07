package step06.streamapi;

import java.util.Arrays;
import java.util.List;

import model.domain.People;

public class StreamAPI2 {

	public static void main(String[] args) {
		List<String> datas = Arrays.asList("1", "2", "3", "4", "15", "3", "3");
		datas.stream().forEach(v -> System.out.println(v + 1)); // 문자열과의 결합 출력
		
		// mapToInt : parameter의 가공 필요, 반환 타입 intStream
		int all = datas.stream().mapToInt(Integer::parseInt).sum();
		System.out.println(all);
		
		double all2 = datas.stream().mapToDouble(Double::parseDouble).sum();
		System.out.println(all2);
		
		// datas의 데이터 개수 출력: stream().mapToInt() 사용하면서 int 개수만 출력
		System.out.println(datas.stream().mapToInt(Integer::parseInt).count());
		System.out.println(datas.stream().mapToInt(Integer::parseInt).max()); 
		// OptionalInt[15]
		
		/* Optional: 값을 보유하는 컨테이너
		 * OptionalInt: int값만 보유하는 컨테이너
		 * OptionalDouble: double값만 보유~.
		 *  
		 * 
		 */
		
		int data1 = datas.stream().mapToInt(Integer::parseInt).max().getAsInt();
		System.out.println(data1);
		
		// datas가 보유한 문자열을 int로 변환하여 3 값에 한해서만 filtering 후 합 출력하기
		System.out.println(datas.stream().mapToInt(Integer::parseInt)
				.filter(v -> v == 3).sum());
		
		
		// 나이값 합 구하기
		List<People> datas2 = Arrays.asList(new People("연아", 30), new People("재석", 50));
		System.out.println(datas2.stream().mapToInt(p -> p.getAge()).sum());
		System.out.println(datas2.stream().mapToInt(People::getAge).sum());
		
		/* Stream<T> filter()
		 * 
		 * Stream<People> filter() : API에서 확인되는 API 이름
		 * 실제 구현체, 즉 생성된 객체명은 ReferencePipeline
		 * - Stream 상속받는 하위 클래스
		 * 
		 * JDK 자체적으로 interface(미완성 메소드) 설계
		 * - 동적으로 실행할 미완성 로직들을 상속받아서 모든 메소드들을 재정의하는 하위 클래스를 생성함
		 * - 객체 생성이 가능(미완성 메소드 하나라도 보유한 interface는 객체 생성 불가)
		 */
		
		// 나이가 40 이상인 people 출력
		System.out.println(datas2.stream().filter(p -> p.getAge() >= 40).findFirst().get());
		datas.stream().mapToInt(Integer::parseInt).filter(v -> v>=3).forEach(System.out::print);
		
		
		
	}

}
