package me.anil.geektrust.lengaburu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import me.anil.geektrust.lengaburu.model.Person;

/*
 * Service class used to find out the relatiion of a person
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
	public static List<Person> findUncles(Person person, boolean isMaternalSide) {
		List<Person> uncles = new ArrayList<Person>();
		Person grandMother = person.findGrandMother(isMaternalSide);
		if (grandMother != null) {
			uncles = grandMother.getChildren().stream().filter(children -> !children.isFemale()
					&& !children.getName().equals(person.getFather() != null ? person.getFather().getName() : ""))
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
	public static List<Person> findAunts(Person person, boolean isMaternalSide) {
		List<Person> aunts = new ArrayList<Person>();
		Person grandMother = person.findGrandMother(isMaternalSide);
		if (grandMother != null) {
			aunts = grandMother.getChildren().stream()
					.filter(children -> children.isFemale() && !children.getName().equals(person.getMother().getName()))
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
	public static List<Person> findSon(Person person) {
		List<Person> son = new ArrayList<Person>();
		if (person != null) {
			son = person.findChildren().stream().filter(per -> !per.isFemale()).collect(Collectors.toList());
		}
		return son;
	}

	/*
	 * This method return the daughter of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public static List<Person> findDaughter(Person person) {
		List<Person> daughters = new ArrayList<Person>();
		if (person != null) {
			daughters = person.findChildren().stream().filter(per -> per.isFemale()).collect(Collectors.toList());
		}
		return daughters;
	}

	/*
	 * This method return the siblings of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public static List<Person> findSiblings(Person person) {
		List<Person> siblings = new ArrayList<Person>();
		if (person != null) {
			siblings = person.getMother().findChildren().stream().filter(per -> !per.getName().equals(person.getName()))
					.collect(Collectors.toList());
		}
		return siblings;
	}

	/*
	 * This method return the brother in law of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public static List<Person> findBrotherInLaw(Person person) {
		List<Person> inLaws = new ArrayList<Person>();
		findSiblings(person).stream().filter(sibling -> sibling.getSpouse() != null && !sibling.getSpouse().isFemale())
				.forEach(sibling -> inLaws.add(sibling.getSpouse()));
		inLaws.addAll(findSiblings(person.getSpouse()).stream().filter(sibling -> !sibling.isFemale())
				.collect(Collectors.toList()));
		return inLaws;
	}

	/*
	 * This method return the sister in law of a given person
	 * 
	 * @param person
	 * 
	 * @return List of persons
	 */
	public static List<Person> findSisterInLaw(Person person) {
		List<Person> inLaws = new ArrayList<Person>();
		findSiblings(person).stream().filter(sibling -> sibling.getSpouse() != null && sibling.getSpouse().isFemale())
				.forEach(sibling -> inLaws.add(sibling.getSpouse()));
		inLaws.addAll(findSiblings(person.getSpouse()).stream().filter(sibling -> sibling.isFemale())
				.collect(Collectors.toList()));
		return inLaws;
	}
}
