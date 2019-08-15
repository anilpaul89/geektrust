package me.anil.geektrust.lengaburu.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import me.anil.geektrust.lengaburu.LengaburuMainLoader;
import me.anil.geektrust.lengaburu.exception.ChildAdditionException;
import me.anil.geektrust.lengaburu.exception.LengaburuBaseException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.utils.Constants;
import me.anil.geektrust.lengaburu.utils.InputTypeEnum;

public class AddChildProcessTest {

	private AddChildProcess childProcess;

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
		childProcess = new AddChildProcess();
	}

	@Test(expected = ChildAdditionException.class)
	public void testProcessCommandWithException() throws LengaburuBaseException {
		childProcess.processCommands(LengaburuModel.getLengaburuModel().getMember("Vyas"),
				InputTypeEnum.ADD_CHILD.toString(), "Vyas", "Anil", "Male");
	}

	@Test
	public void testProcessCommand() throws LengaburuBaseException {
		String response = childProcess.processCommands(LengaburuModel.getLengaburuModel().getMember("Atya"),
				InputTypeEnum.ADD_CHILD.toString(), "Atya", "Anil", "Male");
		assertEquals(Constants.CHILD_ADDITION_SUCCEEDED, response);
	}

}
