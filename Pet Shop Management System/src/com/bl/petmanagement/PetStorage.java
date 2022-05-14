package com.bl.petmanagement;

//import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PetStorage {

	// private ArrayList<Pet> petList = new ArrayList<Pet>();

	private Set<Pet> petList = new HashSet<>();
	static PetStorage instance;

	private PetStorage() {

	}

	public static PetStorage getInstance() {
		if (instance == null) {
			instance = new PetStorage();
		}
		return instance;
	}

	public void add(Pet pet) {
		petList.add(pet);
	}

	public Set getPetList() {
		return petList;
	}

	public void remove(Pet pet) {
		petList.remove(pet);
	}

	public Pet getPet(String petID) {
//		for(Pet pet : petList) {
//			if(pet.id.equals(petID)) {
//				return pet;
//			}
//		}
//		return null;
		return petList.stream().filter(pet -> pet.id.equals(petID)).findFirst().orElse(null);
	}
}