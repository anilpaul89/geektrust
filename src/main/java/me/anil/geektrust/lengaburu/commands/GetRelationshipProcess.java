package me.anil.geektrust.lengaburu.commands;

import java.util.List;

import me.anil.geektrust.lengaburu.exception.CommandProcessException;
import me.anil.geektrust.lengaburu.exception.LengaburuBaseException;
import me.anil.geektrust.lengaburu.model.Person;
import me.anil.geektrust.lengaburu.service.RelationshipFinderService;
import me.anil.geektrust.lengaburu.utils.Constants;
import me.anil.geektrust.lengaburu.utils.RelationshipTypeEnum;

/*
 * This class implements ProcessCommand and used to process command GET_RELATIONSHIP which is coming as from input file
 */

public class GetRelationshipProcess implements ProcessCommand {

	private RelationshipFinderService relationShipService;

	public GetRelationshipProcess() {
		this.relationShipService = new RelationshipFinderService();
	}

	/*
	 * Method overriding for processing GET_RELATIONSHIP
	 */
	@Override
	public String processCommands(Person person, String... inputs) throws LengaburuBaseException {
		List<Person> relatives = null;
		if (inputs.length != 3) {
			throw new CommandProcessException();
		}
		String response = Constants.NONE;
		switch (RelationshipTypeEnum.getRelationShip(inputs[2])) {
		case BROTHER_IN_LAW:
			relatives = this.relationShipService.findBrotherInLaw(person);
			break;
		case SISTER_IN_LAW:
			relatives = this.relationShipService.findSisterInLaw(person);
			break;
		case MATERNAL_AUNT:
			relatives = this.relationShipService.findAunts(person, true);
			break;
		case MATERNAL_UNCLE:
			relatives = this.relationShipService.findUncles(person, true);
			break;
		case PATERNAL_AUNT:
			relatives = this.relationShipService.findAunts(person, false);
			break;
		case PATERNAL_UNCLE:
			relatives = this.relationShipService.findUncles(person, false);
			break;
		case DAUGHTER:
			relatives = this.relationShipService.findDaughter(person);
			break;
		case SIBLINGS:
			relatives = this.relationShipService.findSiblings(person);
			break;
		case SON:
			relatives = this.relationShipService.findSon(person);
			break;
		default:
			System.out.println(Constants.WRONG_RELATION);
			break;
		}
		if (relatives != null && relatives.size() > 0) {
			StringBuilder names = new StringBuilder();
			relatives.stream().forEach(relative -> names.append(relative.getName()).append(" "));
			response = names.toString().trim();
		}

		return response;
	}

}
