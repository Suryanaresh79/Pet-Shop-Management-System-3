package com.bl.petmanagement;

import java.util.Scanner;

import com.bl.petmanagement.Pet.Colour;

public class Main {

	public void handleUserSelection(int choice) {
		Scanner sc = new Scanner(System.in);
		UserInterface userInterface = UserInterface.getInstance();
		PetStorage petStorage = PetStorage.getInstance();
		switch (choice) {

		case 1:
			addPet();
			break;

		case 2:
			userInterface.print(petStorage.getPetList());
			break;

		case 3:
			System.out.println("Please enter the Pet ID that you want to remove from the list");
			String petID = sc.next();
			Pet removePet = petStorage.getPet(petID);
			petStorage.remove(removePet);
			System.out.println(removePet + " is removed from the List");
			break;

		case 4:
			System.out.println("Please enter the Pet ID that you want update in the list");
			String petIDUpdate = sc.next();
			Pet petToUpdate = petStorage.getPet(petIDUpdate);
			updatePet(petToUpdate);
			break;

		case 5:
			System.out.println("Exited from Program");
			break;

		default:
			System.out.println("Invalid Input.., please choose correct option");
		}
	}

	public void updatePet(Pet pet) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choice a parameter to update: \n1. ID \n2. Name \n3. Colour \n4. Age \n5. Price");
		int updateChoice = sc.nextInt();

		switch (updateChoice) {

		case 1:
			System.out.println("Please Enter the new ID to update");
			pet.id = sc.next();
			System.out.println("\nPet ID is updated successully");
			break;

		case 2:
			System.out.println("Please Enter the new Name to update");
			pet.name = sc.next();
			;
			System.out.println("\nPet Name is updated successfully");
			break;

		case 3:
			setColour(pet);
			break;

		case 4:
			System.out.println("Please Enter the new Age to update");
			pet.age = sc.nextInt();
			System.out.println("\nPet Age is updated successfully");
			break;

		case 5:
			System.out.println("Please Enter the new Price to update");
			pet.price = sc.nextInt();
			System.out.println("\nPet Price is updated successfully");
			break;

		default:
			System.out.println("Invalid input.., Please choose correct option");
		}
	}

	public void setColour(Pet pet) {
		Scanner sc1 = new Scanner(System.in);
		// System.out.println("Please select the color:\n1.BLACK \n2.RED \n3.WHITE
		// \n4.BLUE \n5.BLACK_WHITE \n6.GREEN \n7.GRAY");
		int count = 0;
		System.out.println("Available Colours:");
		for (Colour c : Colour.values()) {
			count++;
			System.out.println(count + "." + c);
		}
		int colourChoice = sc1.nextInt();

		switch (colourChoice) {
		case 1:
			pet.color = Colour.BLACK;
			break;

		case 2:
			pet.color = Colour.RED;
			break;

		case 3:
			pet.color = Colour.WHITE;
			break;

		case 4:
			pet.color = Colour.BLUE;
			break;

		case 5:
			pet.color = Colour.BLACK_WHITE;
			break;

		case 6:
			pet.color = Colour.GREEN;
			break;

		case 7:
			pet.color = Colour.GRAY;
			break;

		default:
			System.out.println("Invalid input.., please choose correct option");
		}
	}

	public void addPet() {
		PetStorage petStorage = PetStorage.getInstance();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose what you want add, \n1.Animal\n2.Bird");
		int choice = scanner.nextInt();
		Pet pet = null;
		switch (choice) {
		case 1:
			pet = new Animal();
			System.out.println("Enter Animal Breed");
			Animal animal = (Animal) pet;
			animal.breed = scanner.next();
			break;

		case 2:
			pet = new Bird();
			System.out.println("Enter Bird Breed");
			((Bird) pet).species = scanner.next();
			break;

		default:
			System.out.println("Please enter valid input..");
		}

		System.out.println("Enter ID");
		pet.id = scanner.next();
		System.out.println("Enter Name");
		pet.name = scanner.next();
		System.out.println("Enter Colour");
		setColour(pet);
		System.out.println("Enter Age");
		pet.age = scanner.nextInt();
		System.out.println("Enter Price");
		pet.price = scanner.nextInt();
		petStorage.add(pet);

//		PetStorage petStorage = PetStorage.getInstance();
//		Animal dog = new Dog("D001");
//		dog.breed = "German";
//		dog.age = 5;
//		dog.price = 5000;
//		
//		Animal dog1 = new Dog("D001");
//		dog1.breed = "German1";
//		dog1.age = 4;
//		dog1.price = 500;
//		
//		Bird duck = new Duck("DU001");
//		duck.species = "duck species";
//		duck.age = 8;
//		duck.price = 1500;
//		
//		Bird parrot = new Parrot("P001");
//		parrot.species = "parrot species";
//		parrot.age = 7;
//		parrot.price = 2500;
//		
//		Animal rabbit = new Rabbit("R001");
//		rabbit.breed = "Indian";
//		rabbit.age = 9;
//		rabbit.price = 1000;
//		
//		Animal cat = new Cat("C001");
//		cat.breed = "American";
//		cat.age = 4;
//		cat.price = 250;
//
//		petStorage.add(cat);
//		petStorage.add(dog);
//		petStorage.add(duck);
//		petStorage.add(parrot);
//		petStorage.add(rabbit);
//		petStorage.add(dog1);		
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Pet Management System");

		Main main = new Main();
		UserInterface userInterface = UserInterface.getInstance();
		int choice = 0;
		while (choice != 5) {
			choice = userInterface.showMainMenu();
			main.handleUserSelection(choice);
		}

		/*
		 * Animal dog = new Dog("D001"); dog.breed = "German"; dog.age = 5; dog.price =
		 * 5000; Animal dog1 = new Dog("D001"); dog1.breed = "German1"; dog1.age = 4;
		 * dog1.price = 500; Bird duck = new Duck("DU001"); duck.species =
		 * "duck species"; duck.age = 8; duck.price = 1500; Bird parrot = new
		 * Parrot("P001"); parrot.species = "parrot species"; parrot.age = 7;
		 * parrot.price = 2500; Animal rabbit = new Rabbit("R001"); rabbit.breed =
		 * "Indian"; rabbit.age = 9; rabbit.price = 1000; Animal cat = new Cat("C001");
		 * cat.breed = "American"; cat.age = 4; cat.price = 250;
		 * 
		 * PetStorage petStorage = new PetStorage(); petStorage.add(cat);
		 * petStorage.add(dog); petStorage.add(duck); petStorage.add(parrot);
		 * petStorage.add(rabbit); petStorage.add(dog1);
		 * 
		 * UserInterface userInterface = new UserInterface();
		 * //userInterface.print(petStorage.getPetList()); Set petList =
		 * petStorage.getPetList(); userInterface.print(petList);
		 * 
		 * petStorage.remove(cat); System.out.println("\nAfter removing- Cat");
		 * userInterface.print(petList);
		 * 
		 * System.out.println("Printing Animals:"); userInterface.printAnimals(petList);
		 * System.out.println("\nPrinting Birds:"); userInterface.printBirds(petList);
		 * 
		 * System.out.println("\nPrinting Swimmable Animals:");
		 * userInterface.printSwimmables(petList);
		 */
	}
}
