package com.bl.petmanagement;

import java.util.Objects;

public class Pet {

	enum Colour {
		BLACK, RED, WHITE, BLUE, BLACK_WHITE, GREEN, GRAY
	}

	String id;
	String name;
	Colour color;
	int age;
	int price;

	// public abstract void eat();

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", color=" + color + ", age=" + age + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return Objects.equals(id, other.id);
	}
}