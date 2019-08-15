package me.anil.geektrust.lengaburu.commands;

import me.anil.geektrust.lengaburu.exception.LengaburuBaseException;
import me.anil.geektrust.lengaburu.model.Person;

/*
 * Interface used to process the commands from input file 
 */
public interface ProcessCommand {

	/*
	 * Method used to process Command based on the input file
	 * 
	 * @param : Person
	 * 
	 * @param : inputs coming from the file including process command
	 */
	public String processCommands(Person person, String... inputs) throws LengaburuBaseException;

}
