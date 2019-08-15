package me.anil.geektrust.lengaburu.commands;

import me.anil.geektrust.lengaburu.exception.CommandProcessException;
import me.anil.geektrust.lengaburu.exception.LengaburuBaseException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.model.Person;
import me.anil.geektrust.lengaburu.utils.Constants;
import me.anil.geektrust.lengaburu.utils.GenderTypeEnum;

/*
 * This class implements ProcessCommand and used to process command ADD_SPOUSE which is coming as from input file
 */
public class AddSpouseProcess implements ProcessCommand {

	/*
	 * Method overriding for processing ADD_SPOUSE
	 */
	@Override
	public String processCommands(Person person, String... inputs) throws LengaburuBaseException {
		if (inputs.length != 3) {
			throw new CommandProcessException();
		}
		Person spouse = new Person(inputs[2], person.isFemale() ? GenderTypeEnum.MALE : GenderTypeEnum.FEMALE);
		spouse.setSpouse(person);
		person.setSpouse(spouse);
		LengaburuModel.getLengaburuModel().addNewMember(inputs[2], spouse);
		return Constants.EMPTY_STRING;
	}

}
