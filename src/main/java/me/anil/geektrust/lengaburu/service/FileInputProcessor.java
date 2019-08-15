package me.anil.geektrust.lengaburu.service;

import me.anil.geektrust.lengaburu.commands.ProcessCommand;
import me.anil.geektrust.lengaburu.commands.ProcessCommandFactory;
import me.anil.geektrust.lengaburu.exception.LengaburuBaseException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.model.Person;
import me.anil.geektrust.lengaburu.utils.Constants;
import me.anil.geektrust.lengaburu.utils.InputTypeEnum;

/*
 * This class is used to process the input coming from the file
 * 
 */
public class FileInputProcessor {

	/*
	 * Method used to call the process based on the command
	 */
	public static void processCommand(String command) {
		String[] commandSplit = command.split(Constants.EMPTY_SPACE);
		ProcessCommand processor = ProcessCommandFactory.getCommandProcessor(InputTypeEnum.valueOf(commandSplit[0]));
		if (processor != null) {
			try {
				Person person = LengaburuModel.getLengaburuModel().getMember(commandSplit[1]);
				String response = processor.processCommands(person, commandSplit);

				System.out.println(response);
			} catch (LengaburuBaseException lbe) {

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println(Constants.WRONG_COMMAND);
		}
	}

}
