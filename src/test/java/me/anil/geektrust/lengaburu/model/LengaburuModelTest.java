package me.anil.geektrust.lengaburu.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import me.anil.geektrust.lengaburu.LengaburuMainLoader;
import me.anil.geektrust.lengaburu.exception.PersonNotFoundException;

public class LengaburuModelTest {

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
	}

	@Test
	public void testFindPerson() throws PersonNotFoundException {
		assertEquals(LengaburuModel.getLengaburuModel().getMember("Vyas").getName(), "Vyas");
	}

}
