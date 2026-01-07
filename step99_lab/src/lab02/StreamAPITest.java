package lab02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPITest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sum = Stream.iterate(1, i -> i + 1)
		                 .limit(10_000_000)
		                 .reduce(0, Integer::sum); // Integer 객체 생성 및 언박싱 반복
		long end = System.currentTimeMillis();
		System.out.println("Boxed Stream 소요 시간: " + (end - start) + "ms");
		
		long start2 = System.currentTimeMillis();
		long sum2 = IntStream.rangeClosed(1, 10_000_000)
		                    .sum(); // 기본형 연산
		long end2 = System.currentTimeMillis();
		System.out.println("Primitive Stream 소요 시간: " + (end2 - start2) + "ms");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// 데이터가 적은데 병렬로 처리하면 스레드 생성/분할 오버헤드가 더 큼
		long start3 = System.currentTimeMillis();
		int sum3 = numbers.parallelStream().reduce(0, Integer::sum);
		long end3 = System.currentTimeMillis();
		System.out.println("소요 시간: " + (end3 - start3) + "ms");
		// 작은 리스트는 순차 스트림이 압도적으로 빠름
		long start4 = System.currentTimeMillis();
		int sum4 = numbers.stream().reduce(0, Integer::sum);
		long end4 = System.currentTimeMillis();
		System.out.println("소요 시간: " + (end4 - start4) + "ms");
		
		
	}
}
