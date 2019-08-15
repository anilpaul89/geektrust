package me.anil.geektrust.lengaburu.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import me.anil.geektrust.lengaburu.LengaburuMainLoader;
import me.anil.geektrust.lengaburu.exception.LengaburuBaseException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.utils.InputTypeEnum;

public class GetRelationShipProcessTest {

	private GetRelationshipProcess relationShipProcess;

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
		relationShipProcess = new GetRelationshipProcess();
	}

	@Test
	public void testFindUncles() throws LengaburuBaseException {
		String uncle = relationShipProcess.processCommands(LengaburuModel.getLengaburuModel().getMember("Vasa"),
				InputTypeEnum.GET_RELATIONSHIP.toString(), "Vasa", "Paternal-Uncle");
		assertEquals("Vyas", uncle);

	}

}
