package com.jayasanka.atlasian;

import java.util.ArrayList;

/*
We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

records1 = [
  ["Paul",     "enter"],
  ["Pauline",  "exit"],
  ["Paul",     "enter"],
  ["Paul",     "exit"],
  ["Martha",   "exit"],
  ["Joe",      "enter"],
  ["Martha",   "enter"],
  ["Steve",    "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Joe",      "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Joe",      "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Joe",      "enter"],
  ["Joe",      "enter"],
  ["Martha",   "exit"],
  ["Joe",      "exit"],
  ["Joe",      "exit"] 
]

Expected output: ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]

Other test cases:

records2 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

records3 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]

records4 = [
  ["Raj", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
  ["Paul", "enter"],
  ["Raj", "enter"],
]

Expected output: ["Raj", "Paul"], ["Paul"]

All Test Cases:
mismatches(records1) => ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]
mismatches(records2) => [], []
mismatches(records3) => ["Paul"], ["Paul"]
mismatches(records4) => ["Raj", "Paul"], ["Paul"]

n: length of the badge records array
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CheckEntryExitApp {
	public static void main(String[] argv) {
		String[][] records1 = { 
				{ "Paul", "enter" }, 
				{ "Pauline", "exit" }, 
				{ "Paul", "enter" }, 
				{ "Paul", "exit" },
				{ "Martha", "exit" }, 
				{ "Joe", "enter" }, 
				{ "Martha", "enter" }, 
				{ "Steve", "enter" },
				{ "Martha", "exit" }, 
				{ "Jennifer", "enter" }, 
				{ "Joe", "enter" }, 
				{ "Curtis", "exit" },
				{ "Curtis", "enter" }, 
				{ "Joe", "exit" }, 
				{ "Martha", "enter" }, 
				{ "Martha", "exit" },
				{ "Jennifer", "exit" },
				{ "Joe", "enter" }, 
				{ "Joe", "enter" }, 
				{ "Martha", "exit" }, 
				{ "Joe", "exit" },
				{ "Joe", "exit" }, };

		String[][] records2 = { 
				{ "Paul", "enter" }, 
				{ "Paul", "exit" }, };

		String[][] records3 = { 
				{ "Paul", "enter" }, 
				{ "Paul", "enter" }, 
				{ "Paul", "exit" }, 
				{ "Paul", "exit" }, };

		String[][] records4 = { 
				{ "Raj", "enter" }, 
				{ "Paul", "enter" }, 
				{ "Paul", "exit" }, 
				{ "Paul", "exit" },
				{ "Paul", "enter" }, 
				{ "Raj", "enter" }, };

		List<Set<String>> results = getUsersHasMismatched(records1);
		
		for(Set<String> result : results) {
			for(String r : result) {
				System.out.print(r + " ");
			}
			System.out.println();
		}

	}

	private static List<Set<String>> getUsersHasMismatched(String[][] records) {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		Set<String> wrongEntry = new HashSet<>();
		Set<String> wrongExit = new HashSet<>();

		for (String[] record : records) {
			if (!resultMap.containsKey(record[0])) {
				if (record[1].equals("enter")) {
					resultMap.put(record[0], 1);
					System.out.println("Valid entry for user " + record[0]);
				} else if (record[1].equals("exit")) {
					System.out.println("Wrong exit for user " + record[0]);
					wrongExit.add(record[0]);
				}
			} else {
				if (resultMap.get(record[0]) == 1) {
					if (record[1].equals("enter")) {
						System.out.println("Wrong entry for user " + record[0]);
						wrongEntry.add(record[0]);
					} else if (record[1].equals("exit")) {
						System.out.println("Valid exit for user " + record[0]);
						resultMap.remove(record[0]);
						//resultMap.put(record[0], -1);
					}
				} else if (resultMap.get(record[0]) == -1) {
					if (record[1].equals("enter")) {
						resultMap.put(record[0], 1);
						System.out.println("Valid entry for user " + record[0]);
					} else if (record[1].equals("exit")) {
						System.out.println("Wrong exit for user " + record[0]);
						wrongExit.add(record[0]);
					}
				}
			}
		}
		
		for(String key : resultMap.keySet()) {
			if (resultMap.get(key) == 1) {
				wrongEntry.add(key);
			} else if (resultMap.get(key) == -1){
				wrongExit.add(key);
			}
		}

		List<Set<String>> result = new ArrayList<>();
		result.add(wrongEntry);
		result.add(wrongExit);
				
		return result;

	}

}
