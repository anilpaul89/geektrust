package me.anil.geektrust.lengaburu.service;

import me.anil.geektrust.lengaburu.exception.ChildAdditionException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.model.Person;
import me.anil.geektrust.lengaburu.utils.GenderTypeEnum;

/*
 * This class is used to add child based on the name and gender
 */
public class AddMemberService {

	/*
	 * This method is used to add a child to the person
	 * 
	 * @param mother
	 * 
	 * @param name
	 * 
	 * @param gender
	 * 
	 * @return boolean
	 */
	public static boolean addChild(Person mother, String name, String gender) throws ChildAdditionException {
		boolean isChildAdded = false;
		if (mother != null) {
			if (!mother.isFemale()) {
				throw new ChildAdditionException();
			}
			Person person = new Person(name, GenderTypeEnum.getGenderType(gender));
			person.setMother(mother);
			person.setFather(mother.getSpouse());
			mother.getChildren().add(person);
			LengaburuModel.addNewMember(name, person);
			isChildAdded = true;
		}
		return isChildAdded;
	}

	/*
	 * This method is used to add a spouse to the person
	 * 
	 * @param person
	 * 
	 * @param name
	 * 
	 * @return boolean
	 */

	public static boolean addSpouse(Person person, String name) {
		boolean isSpouseAdded = false;
		Person spouse = new Person(name, person.isFemale() ? GenderTypeEnum.MALE : GenderTypeEnum.FEMALE);
		spouse.setSpouse(person);
		person.setSpouse(spouse);
		LengaburuModel.addNewMember(name, spouse);
		isSpouseAdded = true;
		return isSpouseAdded;
	}
}
