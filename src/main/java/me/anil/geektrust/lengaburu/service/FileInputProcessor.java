package me.anil.geektrust.lengaburu.service;

import me.anil.geektrust.lengaburu.helper.RelationshipHelperService;
import me.anil.geektrust.lengaburu.search.FamilySearch;
import me.anil.geektrust.lengaburu.utils.Constants;
import me.anil.geektrust.lengaburu.utils.InputTypeEnum;
import me.anil.geektrust.lengaburu.utils.RelationshipTypeEnum;

/*
 * This class is used to process the input coming from the file
 * 
 */
public class FileInputProcessor {

	/*
	 * Method used to call the process based on the command
	 */
	public static void processCommand(String command) {
		String[] commandSplit = command.split(" ");
		switch (InputTypeEnum.valueOf(commandSplit[0])) {
		case ADD_CHILD:
			try {
				boolean isSuccess = AddMemberService.addChild(FamilySearch.findPerson(commandSplit[1]), commandSplit[2],
						commandSplit[3]);
				if (isSuccess)
					System.out.println(Constants.CHILD_ADDITION_SUCCEEDED);
			} catch (Exception e) {

			}
			break;
		case GET_RELATIONSHIP:
			try {
				RelationshipHelperService.findRelationShip(FamilySearch.findPerson(commandSplit[1]),
						RelationshipTypeEnum.getRelationShip(commandSplit[2]));
			} catch (Exception e) {
				
			}
			break;
		default:
			System.out.println(Constants.WRONG_COMMAND);
			break;
		}
	}

}
