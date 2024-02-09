package com.jayasanka.codility.orionHealth;

import java.util.ArrayList;

public class ChemicalMachine {

		ArrayList<String> chemicals = new ArrayList<>();
	    
	    public void add(String chemical) {
	        chemicals.add(chemical);
	    }

	    public void applyHeat() {
	        if (chemicals.contains("GREEN") && chemicals.contains("CYAN")) {
	        	chemicals.add("ORANGE");
	        } else if (chemicals.contains("GREEN") && chemicals.contains("YELLOW")) {
	        	chemicals.add("BROWN");
	        } else if (chemicals.contains("ORANGE")){
	        	chemicals.add("RED");
	        	chemicals.add("BLUE");
	        } else if (chemicals.contains("BROWN")) {
	        	chemicals.add("MAGENTA");
	        } else {
	        	chemicals.add("UNKNOWN");
	        }
	    }

	    public ArrayList<String> emptyMachine() {
	    	ArrayList<String> chemicalsContains = new ArrayList<>(chemicals);
	    	chemicals.clear();
	        return chemicalsContains;
	    }

	    public static void main(String[] args) {
	        ChemicalMachine machine = new ChemicalMachine();

	        machine.add("GREEN");
	        machine.add("YELLOW");
	        machine.applyHeat();
	        System.out.println(machine.emptyMachine()); // emptyMachine should return {"BROWN"}

	        machine.add("RED");
	        machine.add("YELLOW");
	        machine.applyHeat();
	        System.out.println(machine.emptyMachine()); // emptyMachine should return {"UNKOWN"}
	    }

}
