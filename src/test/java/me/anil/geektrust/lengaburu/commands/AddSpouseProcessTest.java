package me.anil.geektrust.lengaburu.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import me.anil.geektrust.lengaburu.LengaburuMainLoader;
import me.anil.geektrust.lengaburu.exception.LengaburuBaseException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.utils.Constants;
import me.anil.geektrust.lengaburu.utils.InputTypeEnum;

public class AddSpouseProcessTest {

	private AddSpouseProcess spouseProcess;

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
		spouseProcess = new AddSpouseProcess();
	}

	@Test
	public void testProcessCommand() throws LengaburuBaseException {
		String response = spouseProcess.processCommands(LengaburuModel.getLengaburuModel().getMember("Atya"),
				InputTypeEnum.ADD_SPOUSE.toString(), "Atya", "Anil");
		assertEquals(Constants.EMPTY_STRING, response);
	}
}
