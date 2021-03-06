package me.anil.geektrust.lengaburu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import me.anil.geektrust.lengaburu.utils.GenderTypeEnum;

/*
 * This class is used to denote a person in the family hierarchy
 * 
 * @author : Anil Paul
 */
public class Person {

	private String name;

	private GenderTypeEnum gender;

	private Person father;

	private Person mother;

	private List<Person> children;

	private Person spouse;

	public boolean isFemale() {
		return GenderTypeEnum.FEMALE.equals(gender);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GenderTypeEnum getGender() {
		return gender;
	}

	public void setGender(GenderTypeEnum gender) {
		this.gender = gender;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public List<Person> getChildren() {
		if (this.children == null && isFemale()) {
			this.children = new ArrayList<Person>();
		}
		return children;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public Person(String name, GenderTypeEnum gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	/*
	 * This method returns grandmother of a person
	 * 
	 * @param isMaternalSide boolean to check the maternal side or paternal side
	 * 
	 * @return Person
	 */
	public Person findGrandMother(boolean isMaternalSide) {
		Person parent = isMaternalSide ? this.getMother() : this.getFather();
		return parent != null ? parent.getMother() : null;
	}

	/*
	 * This method return the children of a given parent
	 * 
	 * @return List of persons
	 */
	public List<Person> findChildren() {
		return this.isFemale() ? this.getChildren()
				: this.getSpouse() != null ? this.getSpouse().getChildren() : new ArrayList<Person>();
	}

	/*
	 * This method return the siblings of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons - siblings
	 */
	public List<Person> findSiblings() {
		List<Person> siblings = new ArrayList<Person>();
		if (this.getMother() != null) {
			// find the mother of current person and then get the children and remove the
			// current person
			siblings = this.getMother().findChildren().stream().filter(per -> !per.getName().equals(this.getName()))
					.collect(Collectors.toList());
		}
		return siblings;
	}

	/*
	 * This method return the sons of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public List<Person> findSon() {
		List<Person> son = new ArrayList<Person>();
		son = this.findChildren().stream().filter(per -> !per.isFemale()).collect(Collectors.toList());
		return son;
	}

	/*
	 * This method return the daughter of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public List<Person> findDaughter() {
		List<Person> daughters = new ArrayList<Person>();
		daughters = this.findChildren().stream().filter(per -> per.isFemale()).collect(Collectors.toList());
		return daughters;
	}

}
