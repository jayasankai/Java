package com.jayasanka.generics;

import java.util.ArrayList;
import java.util.List;

public class TestGenericsWithWildCards {

	public static void main(String[] args) {
		
		List<Building> buildings = new ArrayList<>();
		buildings.add(new House());
		buildings.add(new Office());
		printAllBuildings(buildings);
		
		List<House> houses = new ArrayList<>();
		houses.add(new House());
		houses.add(new House());
		printAllBuildings(houses);
		
		List<Office> offices = new ArrayList<>();
		offices.add(new Office());
		offices.add(new Office());
		printAllBuildings(offices);
		
	}
	
	public static void printAllBuildings(List<? extends Building> buildings) {
		for (Building b : buildings) {
			System.out.println(b);
		}
	}
	
	public static void printSuperHouses(List<? super House> buildings, House h) {
		buildings.add(h);
	}
}


class Building {
	@Override
	public String toString() {
		return "Building";
	}
}

class House extends Building {
	@Override
	public String toString() {
		return "House";
	}
}

class Office extends Building {
	@Override
	public String toString() {
		return "Office";
	}
}