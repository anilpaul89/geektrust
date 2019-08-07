package me.anil.geektrust.lengaburu.helper;

import java.util.List;

import me.anil.geektrust.lengaburu.model.Person;
import me.anil.geektrust.lengaburu.service.RelationshipFinderService;
import me.anil.geektrust.lengaburu.utils.Constants;
import me.anil.geektrust.lengaburu.utils.RelationshipTypeEnum;

/*
 * Helper class used to delegate the call to relation find service
 * 
 * @author Anil Paul
 */
public class RelationshipHelperService {

	public static void findRelationShip(Person person, RelationshipTypeEnum relation) {
		List<Person> relatives = null;
		switch (relation) {
		case BROTHER_IN_LAW:
			relatives = RelationshipFinderService.findBrotherInLaw(person);
			break;
		case SISTER_IN_LAW:
			relatives = RelationshipFinderService.findSisterInLaw(person);
			break;
		case MATERNAL_AUNT:
			relatives = RelationshipFinderService.findAunts(person, true);
			break;
		case MATERNAL_UNCLE:
			relatives = RelationshipFinderService.findUncles(person, true);
			break;
		case PATERNAL_AUNT:
			relatives = RelationshipFinderService.findAunts(person, false);
			break;
		case PATERNAL_UNCLE:
			relatives = RelationshipFinderService.findUncles(person, false);
			break;
		case DAUGHTER:
			relatives = RelationshipFinderService.findDaughter(person);
			break;
		case SIBLINGS:
			relatives = RelationshipFinderService.findSiblings(person);
			break;
		case SON:
			relatives = RelationshipFinderService.findSon(person);
			break;
		default:
			System.out.println(Constants.WRONG_RELATION);
			break;
		}
		if (relatives != null && relatives.size() > 0) {
			StringBuilder names = new StringBuilder();
			relatives.stream().forEach(relative -> names.append(relative.getName()).append(" "));
			System.out.println(names.toString().trim());
		} else {
			System.out.println(Constants.NONE);
		}
	}
}
