package me.anil.geektrust.lengaburu;

import me.anil.geektrust.lengaburu.commands.AddChildProcess;
import me.anil.geektrust.lengaburu.commands.AddSpouseProcess;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.utils.InputTypeEnum;

/*
 * Loader class used to load the initial hierarchy from king as shown in the picture
 * 
 * @author : Anil Paul
 */
public class LengaburuMainLoader {

	public static void initializeFamliy() {
		LengaburuModel lengaburu = LengaburuModel.getLengaburuModel();
		AddChildProcess childProcess = new AddChildProcess();
		AddSpouseProcess spouseProcess = new AddSpouseProcess();
		try {
			childProcess.processCommands(lengaburu.getQueen(), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getQueen().getName(), "Ish", "Male");
			childProcess.processCommands(lengaburu.getQueen(), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getQueen().getName(), "Vich", "Male");
			childProcess.processCommands(lengaburu.getQueen(), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getQueen().getName(), "Aras", "Male");
			childProcess.processCommands(lengaburu.getQueen(), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getQueen().getName(), "Satya", "Female");

			spouseProcess.processCommands(lengaburu.getMember("Ish"), InputTypeEnum.ADD_SPOUSE.toString(),
					lengaburu.getMember("Ish").getName(), "Amba");
			spouseProcess.processCommands(lengaburu.getMember("Aras"), InputTypeEnum.ADD_SPOUSE.toString(),
					lengaburu.getMember("Aras").getName(), "Chitra");
			spouseProcess.processCommands(lengaburu.getMember("Vich"), InputTypeEnum.ADD_SPOUSE.toString(),
					lengaburu.getMember("Vich").getName(), "Lika");
			spouseProcess.processCommands(lengaburu.getMember("Satya"), InputTypeEnum.ADD_SPOUSE.toString(),
					lengaburu.getMember("Satya").getName(), "Vyan");

			// Ambas Spouse and children
			childProcess.processCommands(lengaburu.getMember("Amba"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Amba").getName(), "Dritha", "Female");
			childProcess.processCommands(lengaburu.getMember("Amba"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Amba").getName(), "Tritha", "Female");
			childProcess.processCommands(lengaburu.getMember("Amba"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Amba").getName(), "Vritha", "Male");
			spouseProcess.processCommands(lengaburu.getMember("Dritha"), InputTypeEnum.ADD_SPOUSE.toString(),
					lengaburu.getMember("Dritha").getName(), "Jaya");
			childProcess.processCommands(lengaburu.getMember("Dritha"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Dritha").getName(), "Yodhan", "Male");

			// Lika Spouse and children
			childProcess.processCommands(lengaburu.getMember("Lika"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Lika").getName(), "Vila", "Female");
			childProcess.processCommands(lengaburu.getMember("Lika"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Lika").getName(), "Chika", "Female");

			// Chitra children and their spouse
			childProcess.processCommands(lengaburu.getMember("Chitra"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Chitra").getName(), "Jnki", "Female");
			childProcess.processCommands(lengaburu.getMember("Chitra"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Chitra").getName(), "Ahit", "Male");
			spouseProcess.processCommands(lengaburu.getMember("Jnki"), InputTypeEnum.ADD_SPOUSE.toString(),
					lengaburu.getMember("Jnki").getName(), "Arit");

			// Jnki children
			childProcess.processCommands(lengaburu.getMember("Jnki"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Jnki").getName(), "Laki", "Male");
			childProcess.processCommands(lengaburu.getMember("Jnki"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Jnki").getName(), "Lavnya", "Female");

			// Satya's Children and their spouse
			childProcess.processCommands(lengaburu.getMember("Satya"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Satya").getName(), "Asva", "Male");
			childProcess.processCommands(lengaburu.getMember("Satya"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Satya").getName(), "Vyas", "Male");
			childProcess.processCommands(lengaburu.getMember("Satya"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Satya").getName(), "Atya", "Female");
			spouseProcess.processCommands(lengaburu.getMember("Vyas"), InputTypeEnum.ADD_SPOUSE.toString(),
					lengaburu.getMember("Vyas").getName(), "Krpi");
			spouseProcess.processCommands(lengaburu.getMember("Asva"), InputTypeEnum.ADD_SPOUSE.toString(),
					lengaburu.getMember("Asva").getName(), "Satvy");

			// Satvy and Krpi children
			childProcess.processCommands(lengaburu.getMember("Satvy"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Satvy").getName(), "Vasa", "Male");
			childProcess.processCommands(lengaburu.getMember("Krpi"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Krpi").getName(), "Kriya", "Male");
			childProcess.processCommands(lengaburu.getMember("Krpi"), InputTypeEnum.ADD_CHILD.toString(),
					lengaburu.getMember("Krpi").getName(), "Krithi", "Female");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
