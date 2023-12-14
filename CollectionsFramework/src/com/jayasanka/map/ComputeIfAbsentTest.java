package com.jayasanka.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfAbsentTest {

	public static void main(String[] args) {
		Map<String, Integer> stringLength = new HashMap<>();
		stringLength.put("John", 1984);
		
		System.out.println(stringLength.computeIfAbsent("John", s -> s.length()));
		
		System.out.println(stringLength.computeIfAbsent("Anne", s -> s.length()));

	}

}
