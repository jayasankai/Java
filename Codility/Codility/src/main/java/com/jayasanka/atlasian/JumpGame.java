package com.jayasanka.atlasian;

import java.util.Arrays;
import java.util.List;

public class JumpGame {

	public static void main(String[] args) {
		int[] obstacles_1 = { 4, 6 };
		int[] obstacles_2 = { 2, 9, 4 };
		int[] obstacles_3 = {};

		String instructions_1 = "RRRJJRRR";
		String instructions_2 = "RRRLJ";
		String instructions_3 = "RRRJJRRRL";
		String instructions_4 = "RRRLRJJRRR";
		String instructions_5 = "RRRRRRRRRR";
		String instructions_6 = "RRJJJJ";
		String instructions_7 = "RLRRRJJRRLLJJJLRRRJJRRR";
		String instructions_8 = "RRRJJRLJJJRRR";
		String instructions_9 = "R";
		String instructions_10 = "RJJJJR";
		String instructions_11 = "RJJRRRJ";

		boolean done = isCompleateGame(instructions_7, obstacles_2);
		System.out.println(done);

	}

	private static boolean isCompleateGame(String instructions, int[] obstacles) {
		List<Integer> obstaclesList = Arrays.stream(obstacles).boxed().toList();

		boolean isCompleated = false;
		String[] instructionsArr = instructions.split("");

		int possition = 0;
		boolean isForword = true;

		for (int i = 0; i < instructionsArr.length; i++) {
			String instruction = instructionsArr[i];
			if ("R".equals(instruction)) {
				if(!hasObstacle(obstaclesList, possition)) {					
					possition++;
				}
				isForword = true;
				System.out.println("instruction= " + instruction + ". Walk frwd. new possition:" + possition);
			} else if ("L".equals(instruction)) {
				if(!hasObstacle(obstaclesList, possition)) {					
					if(possition > 0) possition--;
				}
				isForword = false;
				System.out.println("instruction= " + instruction + ". Walk Bkwd. new possition:" + possition);
			} else if ("J".equals(instruction)) {
				if (isForword) {
					possition = possition + 2;
					hasObstacle(obstaclesList, possition);
					isForword = true;
					System.out.println("instruction= " + instruction + ". Jumped frwd. new possition:" + possition);
				} else {
					possition = possition - 2;
					hasObstacle(obstaclesList, possition);
					isForword = false;
					System.out.println("instruction= " + instruction + ". Jumped Bkwd. new possition:" + possition);
				}
			}
		}

		return isCompleated;
	}
	
	private static boolean hasObstacle(List<Integer> obstaclesList, int possition) {
		if (obstaclesList.contains(possition)) {
			System.out.println("Faced to obstacle...");
			return true;
		} else {
			return false;
		}
	}

}
