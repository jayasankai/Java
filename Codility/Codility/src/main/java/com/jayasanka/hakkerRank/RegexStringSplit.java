package com.jayasanka.hakkerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegexStringSplit {

	public static void main(String[] args) {
		String s = "Hello, thanks for attempting this problem! Hope it will help you to learn java! Good luck and have a nice day!";

		String[] sArr = s.split("[ !,?._'@]+");
		List<String> result = new ArrayList<>();

		result = Arrays.stream(sArr).filter(data -> (data.trim().length() > 0)).collect(Collectors.toList());
		System.out.println(result.size());
		result.forEach(data -> {
			System.out.println(data);
		});
	}
}
