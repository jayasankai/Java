package com.jayasanka.generics;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {

	public static void main(String[] args) {
		List<String> stringList = convertToList(new String[] {"A", "B", "C", "D"});
		List<Integer> integerList = convertToList(new Integer[] {1, 2, 3, 4});
		
		for (String val : stringList) {
			System.out.println(val);
		}
		
		for (Integer val : integerList) {
			System.out.println(val);
		}


	}
	
	
	public static <T> List<T> convertToList(T[] array) {
		List<T> list= new ArrayList<T>();
		
		for (T item : array) {
			list.add(item);
		}
		
		return list;
	}

}
