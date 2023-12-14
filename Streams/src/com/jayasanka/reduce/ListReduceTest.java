package com.jayasanka.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListReduceTest {

	public static void main(String[] args) throws InterruptedException {
		String[] countiesArr = new String[] { "Panama", "Maldives", "Denmark", "Egypt", "Netherlands", "Malaysia",
				"Singapore", "Australia" };
		List<String> counties = new ArrayList<>(Arrays.asList(countiesArr));

		// counties.stream().forEach(System.out::println);
		// counties.stream().sorted().forEach(System.out::println);
		counties.stream().sorted().takeWhile(s -> {
			boolean itestLenght = true;
			System.out.println(s);
			if (s.length() == 8) {
				return false;
			}

			return itestLenght;
		}).forEach(System.out::println);

	}

}
