package me.anil.geektrust.lengaburu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import me.anil.geektrust.lengaburu.model.Person;

/*
 * Service class used to find out the relation of a person
 * 
 * @author : Anil Paul
 */
public class RelationshipFinderService {

	/*
	 * This method return the maternal or paternal uncles of the person
	 * 
	 * @param person
	 * 
	 * @param isMaternalSide - true for maternal and false for paternal
	 * 
	 * @return List of uncles
	 */
	public List<Person> findUncles(Person person, boolean isMaternalSide) {
		List<Person> uncles = new ArrayList<Person>();
		// Logic is to find the grandmother of given person either in paternal or
		// maternal side, then find sons of grand parent and remove current persons
		// mother from that list
		Person grandMother = person.findGrandMother(isMaternalSide);
		if (grandMother != null) {
			uncles = grandMother.findSon().stream()
					.filter(children -> !children.getName()
							.equals(person.getFather() != null ? person.getFather().getName() : ""))
					.collect(Collectors.toList());
		}
		return uncles;

	}

	/*
	 * This method return the maternal or paternal aunts of the person
	 * 
	 * @param person
	 * 
	 * @param isMaternalSide - true for maternal and false for paternal
	 * 
	 * @return List of aunts
	 */
	public List<Person> findAunts(Person person, boolean isMaternalSide) {
		List<Person> aunts = new ArrayList<Person>();
		// Logic is to find the grandmother of given person either in paternal or
		// maternal side, then find daughters of grand parent and remove current persons
		// mother from that list
		Person grandMother = person.findGrandMother(isMaternalSide);
		if (grandMother != null) {
			aunts = grandMother.findDaughter().stream()
					.filter(children -> !children.getName().equals(person.getMother().getName()))
					.collect(Collectors.toList());
		}
		return aunts;

	}

	/*
	 * This method return the sons of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public List<Person> findSon(Person person) {
		List<Person> son = person.findSon();
		return son;
	}

	/*
	 * This method return the daughter of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public List<Person> findDaughter(Person person) {
		List<Person> daughters = person.findDaughter();
		return daughters;
	}

	/*
	 * This method return the brother in law of a given person Brother in Law
	 * includes given person's sisters husband and given person's spouse brothers
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public List<Person> findBrotherInLaw(Person person) {
		List<Person> inLaws = new ArrayList<Person>();
		// Step 1 need to find the husbands of his/her sisters
		// Get the siblings iterate over each sibling and check each siblings spouse is
		// male
		person.findSiblings().stream().filter(sibling -> sibling.getSpouse() != null && !sibling.getSpouse().isFemale())
				.forEach(sibling -> inLaws.add(sibling.getSpouse()));
		// Step 2 Find the brothers of his/her spouse
		// Get the siblings of given persons spouse iterate over each sibling and take
		// whoever is male
		if (person.getSpouse() != null) {
			inLaws.addAll(person.getSpouse().findSiblings().stream().filter(sibling -> !sibling.isFemale())
					.collect(Collectors.toList()));
		}
		return inLaws;
	}

	/*
	 * This method return the sister in law of a given person Sister in Law includes
	 * given person's brothers wife and given person's spouse sisters
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public List<Person> findSisterInLaw(Person person) {
		List<Person> inLaws = new ArrayList<Person>();
		// Step 1 need to find the wifes of his/her brothers
		// Get the siblings iterate over each sibling and check each siblings spouse is
		// female
		person.findSiblings().stream().filter(sibling -> sibling.getSpouse() != null && sibling.getSpouse().isFemale())
				.forEach(sibling -> inLaws.add(sibling.getSpouse()));
		// Step 2 Find the sisters of his/her spouse
		// Get the siblings of given persons spouse iterate over each sibling and take
		// whoever is female
		if (person.getSpouse() != null) {
			inLaws.addAll(person.getSpouse().findSiblings().stream().filter(sibling -> sibling.isFemale())
					.collect(Collectors.toList()));
		}
		return inLaws;
	}

	/*
	 * This method return the siblings of a given person
	 * 
	 * @param person
	 * 
	 * @return List of Person
	 */
	public List<Person> findSiblings(Person person) {
		return person.findSiblings();
	}
}
