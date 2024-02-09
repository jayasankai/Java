package com.jayasanka.hakkerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SteadyGene {

	public static void main(String[] args) {
		String gene = "ACTGAAAG";

		int steadyVal = gene.length() / 4;

		char[] geneCharArr = gene.toCharArray();
		List<String> geneArr = new ArrayList<>();
		Map<String, Integer> geneMap = new HashMap<>();

		for (char c : geneCharArr) {
			String val = String.valueOf(c);
			geneArr.add(val);

			Integer prveCount = geneMap.putIfAbsent(val, 1);
			if (prveCount != null) {
				geneMap.put(val, ++prveCount);
			}
		}
		
		for (int i = 0; i < geneCharArr.length; i++) {
			
			for (int j = 0; j < geneCharArr.length; j++) {
				
			}
		}
		
		

		System.out.println(geneMap);

	}
	
	
	private boolean isValid(Map<String, Integer> geneMap, String val, int steadyVal) {
		if (geneMap.get(val) <= steadyVal) {
			return true;
		}
		return false;
	}

}
