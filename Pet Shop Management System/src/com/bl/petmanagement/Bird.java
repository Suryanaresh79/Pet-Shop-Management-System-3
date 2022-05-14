package com.bl.petmanagement;

public class Bird extends Pet {
	String species;

	@Override
	public String toString() {
		return "Bird [species=" + species + ", id=" + id + ", name=" + name + ", color=" + color + ", age=" + age
				+ ", price=" + price + "]";
	}
}
