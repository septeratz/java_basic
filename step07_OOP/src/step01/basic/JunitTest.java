package step01.basic;

import model.domain.Customer;

import org.junit.Test;

public class JunitTest {

	@Test
	public void Test() {
		Customer c1 = new Customer("ce", 1);
		Customer c2 = new Customer("ce", 1);
		Customer c3 = new Customer("fisa", 1);

		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c2.equals(c3));

	}
}
