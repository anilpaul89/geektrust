package me.anil.geektrust.lengaburu.commands;

import me.anil.geektrust.lengaburu.exception.ChildAdditionException;
import me.anil.geektrust.lengaburu.exception.CommandProcessException;
import me.anil.geektrust.lengaburu.exception.LengaburuBaseException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.model.Person;
import me.anil.geektrust.lengaburu.utils.Constants;
import me.anil.geektrust.lengaburu.utils.GenderTypeEnum;

/*
 * This class implements ProcessCommand and used to process command ADD_SPOUSE which is coming as from input file
 */

public class AddChildProcess implements ProcessCommand {


	/*
	 * Method overriding for processing ADD_CHILD
	 */
	@Override
	public String processCommands(Person mother, String... inputs) throws LengaburuBaseException {
		if (mother != null && !mother.isFemale()) {
			throw new ChildAdditionException();
		}
		if (inputs.length != 4) {
			throw new CommandProcessException();
		}
		Person person = new Person(inputs[2], GenderTypeEnum.getGenderType(inputs[3]));
		person.setMother(mother);
		person.setFather(mother.getSpouse());
		mother.getChildren().add(person);
		LengaburuModel.getLengaburuModel().addNewMember(inputs[2], person);
		return Constants.CHILD_ADDITION_SUCCEEDED;

	}

}
