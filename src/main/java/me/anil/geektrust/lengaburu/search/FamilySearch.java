package me.anil.geektrust.lengaburu.search;

import me.anil.geektrust.lengaburu.exception.PersonNotFoundException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.model.Person;;

/*
 * This class is used to search user based on different criteria
 */
public class FamilySearch {

	/*
	 * This method is used to find a person based on the name
	 * 
	 * @param name
	 * 
	 * @return Person
	 */
	public static Person findPerson(String name) throws PersonNotFoundException {
		Person person = LengaburuModel.getMember(name);
		if (person == null) {
			throw new PersonNotFoundException();
		}
		return person;
	}
}
