package me.anil.geektrust.lengaburu.commands;

import me.anil.geektrust.lengaburu.utils.InputTypeEnum;

/*
 * Factory Class used to get the processor class based on the input type 
 */
public class ProcessCommandFactory {

	/*
	 * This method is used to get the processor based on the input type
	 * 
	 * @param : InputTypeEnum
	 * 
	 * @return : ProcessCommand
	 */
	public static ProcessCommand getCommandProcessor(InputTypeEnum input) {
		ProcessCommand processor = null;
		switch (input) {
		case ADD_CHILD: {
			processor = new AddChildProcess();
			break;
		}
		case ADD_SPOUSE: {
			processor = new AddSpouseProcess();
			break;
		}
		case GET_RELATIONSHIP: {
			processor = new GetRelationshipProcess();
			break;
		}
		default: {
			break;
		}
		}
		return processor;
	}
}
