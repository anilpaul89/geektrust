package me.anil.geektrust.lengaburu.model;

import java.util.LinkedHashMap;
import java.util.Map;

import me.anil.geektrust.lengaburu.exception.PersonNotFoundException;
import me.anil.geektrust.lengaburu.utils.GenderTypeEnum;

public class LengaburuModel {

	private Person king;

	private Person queen;

	private static LengaburuModel lengaburu;

	private Map<String, Person> members;

	public Person getKing() {
		return king;
	}

	private void setKing(Person king) {
		this.king = king;
	}

	public Person getQueen() {
		return queen;
	}

	private void setQueen(Person queen) {
		this.queen = queen;
	}

	private LengaburuModel() {
		members = new LinkedHashMap<String, Person>();
	}

	public static LengaburuModel getLengaburuModel() {
		if (lengaburu == null) {
			lengaburu = new LengaburuModel();
			// Adding King
			Person king = new Person("King Shan", GenderTypeEnum.MALE);
			// Adding Queen
			Person queen = new Person("Queen Anga", GenderTypeEnum.FEMALE);
			// Setting the relation
			king.setSpouse(queen);
			queen.setSpouse(king);

			// Adding the king and queen to lengaburu model
			lengaburu.setKing(king);
			lengaburu.setQueen(queen);

			// Adding king and queen to the member details
			lengaburu.addNewMember(king.getName(), king);
			lengaburu.addNewMember(queen.getName(), queen);

		}
		return lengaburu;
	}

	/*
	 * Needs to call this method when ever a new member is added to the family
	 * 
	 * @param : Name of the person
	 * 
	 * @param : Person
	 */
	public void addNewMember(String name, Person person) {
		members.put(name, person);
	}

	/*
	 * Needs to call this method return the person with the given name
	 * 
	 * @param : Name of the person
	 * 
	 * @return : Person
	 * 
	 * 
	 */
	public Person getMember(String name) throws PersonNotFoundException {
		Person person = members.get(name);
		if (person == null) {
			throw new PersonNotFoundException();
		}
		return person;
	}

}
