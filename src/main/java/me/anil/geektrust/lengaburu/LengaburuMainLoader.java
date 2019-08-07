package me.anil.geektrust.lengaburu;

import me.anil.geektrust.lengaburu.service.AddMemberService;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.search.FamilySearch;

/*
 * Loader class used to load the initial hierarchy from king as shown in the picture
 * 
 * @author : Anil Paul
 */
public class LengaburuMainLoader {

	public static void initializeFamliy() {
		LengaburuModel lengaburu = LengaburuModel.getLengaburuModel();
		try {
			// Queens Children And their spouses
			AddMemberService.addChild(lengaburu.getQueen(), "Chit", "Male");
			AddMemberService.addChild(lengaburu.getQueen(), "Ish", "Male");
			AddMemberService.addChild(lengaburu.getQueen(), "Vich", "Male");
			AddMemberService.addChild(lengaburu.getQueen(), "Aras", "Male");
			AddMemberService.addChild(lengaburu.getQueen(), "Satya", "Female");
			AddMemberService.addSpouse(FamilySearch.findPerson("Chit"), "Amba");
			AddMemberService.addSpouse(FamilySearch.findPerson("Aras"), "Chitra");
			AddMemberService.addSpouse(FamilySearch.findPerson("Vich"), "Lika");
			AddMemberService.addSpouse(FamilySearch.findPerson("Satya"), "Vyan");

			// Ambas Spouse and children
			AddMemberService.addChild(FamilySearch.findPerson("Amba"), "Dritha", "Female");
			AddMemberService.addChild(FamilySearch.findPerson("Amba"), "Tritha", "Female");
			AddMemberService.addChild(FamilySearch.findPerson("Amba"), "Vritha", "Male");
			AddMemberService.addSpouse(FamilySearch.findPerson("Dritha"), "Jaya");
			AddMemberService.addChild(FamilySearch.findPerson("Dritha"), "Yodhan", "Male");

			// Lika Spouse and children
			AddMemberService.addChild(FamilySearch.findPerson("Lika"), "Vila", "Female");
			AddMemberService.addChild(FamilySearch.findPerson("Lika"), "Chika", "Female");

			// Chitra children and their spouse
			AddMemberService.addChild(FamilySearch.findPerson("Chitra"), "Jnki", "Female");
			AddMemberService.addChild(FamilySearch.findPerson("Chitra"), "Ahit", "Male");
			AddMemberService.addSpouse(FamilySearch.findPerson("Jnki"), "Arit");

			// Jnki children
			AddMemberService.addChild(FamilySearch.findPerson("Jnki"), "Laki", "Male");
			AddMemberService.addChild(FamilySearch.findPerson("Jnki"), "Lavnya", "Female");

			// Satya's Children and their spouse
			AddMemberService.addChild(FamilySearch.findPerson("Satya"), "Asva", "Male");
			AddMemberService.addChild(FamilySearch.findPerson("Satya"), "Vyas", "Male");
			AddMemberService.addChild(FamilySearch.findPerson("Satya"), "Atya", "Female");
			AddMemberService.addSpouse(FamilySearch.findPerson("Vyas"), "Krpi");
			AddMemberService.addSpouse(FamilySearch.findPerson("Asva"), "Satvy");

			// Satvy and Krpi children
			AddMemberService.addChild(FamilySearch.findPerson("Satvy"), "Vasa", "Male");
			AddMemberService.addChild(FamilySearch.findPerson("Krpi"), "Kriya", "Male");
			AddMemberService.addChild(FamilySearch.findPerson("Krpi"), "Krithi", "Female");
		} catch (Exception e) {

		}
	}
}
