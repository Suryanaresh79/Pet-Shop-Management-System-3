package com.bl.petmanagement;

public class Animal extends Pet {
	String breed;

	@Override
	public String toString() {
		return "Animal [breed=" + breed + ", id=" + id + ", name=" + name + ", color=" + color + ", age=" + age
				+ ", price=" + price + "]";
	}
}