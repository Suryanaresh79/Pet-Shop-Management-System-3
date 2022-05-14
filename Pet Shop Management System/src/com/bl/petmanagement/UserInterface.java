package com.bl.petmanagement;

import java.util.Scanner;
import java.util.Set;

public class UserInterface {

	static UserInterface instance;

	private UserInterface() {

	}

	public static UserInterface getInstance() {
		if (instance == null) {
			instance = new UserInterface();
		}
		return instance;
	}

	public void print(Set<Pet> petList) {
		/*
		 * for (int i = 0; i < petList.size(); i++) {
		 * System.out.println(petList.get(i)); }
		 */

//		for(Object o: petList) {
//			System.out.println(o);
//		}

		petList.stream().forEach(System.out::println);
		// petList.stream().forEach(s -> System.out.println(s));
	}

	public void printAnimals(Set<Pet> petList) {
//		for(Pet p: petList) {
//			if(p instanceof Animal) {
//				System.out.println(p);
//			}		
//		}

		petList.stream().filter(animal -> animal instanceof Animal).forEach(System.out::println);
	}

	public void printBirds(Set<Pet> petList) {
//		for(Pet p: petList) {
//			if(p instanceof Bird) {
//				System.out.println(p);
//			}		
//		}
		petList.stream().filter(pet -> pet instanceof Bird).forEach(System.out::println);
	}

	public void printSwimmables(Set<Pet> petList) {
//		for(Pet p: petList) {
//			if(p instanceof Swimmable) {
//				Swimmable swimmablePet = (Swimmable)p;
//				swimmablePet.swim();
//			}		
//		}
		petList.stream().filter(pet -> pet instanceof Swimmable).forEach(swimpet -> ((Swimmable) swimpet).swim());
	}

	public int showMainMenu() {
		System.out.println(
				"\nSelect from the below Menu:\n1.Add pet \n2.Print Pet \n3.Remove Pet \n4.Update Pet \n5.Exit");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		return choice;
	}

}