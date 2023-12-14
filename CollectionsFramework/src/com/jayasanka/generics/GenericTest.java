package com.jayasanka.generics;

import com.jayasanka.Animal;
import com.jayasanka.Cat;
import com.jayasanka.Dog;

public class GenericTest {

	public static void main(String[] args) {
		Printer<Integer> integerPrinter = new Printer<Integer>(23);
		integerPrinter.print();
		
		Printer<String> stringPrinter = new Printer<String>("Test String");
		stringPrinter.print();
		
		Printer<Animal> animalPrinter = new Printer<Animal>(new Dog("Butty"));
		animalPrinter.print();
		
		/**
		 * Type safe filter allows only sub types of animals.
		 */
//		AnimalPrinter<Integer> integerPrinter2 = new AnimalPrinter<Integer>(23);
//		integerPrinter.print();
		
		AnimalPrinter<Animal> realAnimalPrinter = new AnimalPrinter<Animal>(new Cat("Sathili, Pathili"));
		realAnimalPrinter.print();
		
		
		Animal dog = new Dog("Butty");
		Animal cat =new Cat("Sathili, Pathili");
		realAnimalPrinter.print(dog, cat);

	}

}
