package me.anil.geektrust.lengaburu.search;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import me.anil.geektrust.lengaburu.LengaburuMainLoader;
import me.anil.geektrust.lengaburu.exception.PersonNotFoundException;

public class FamilySearchTest {

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
	}

	@Test
	public void testFindPerson() throws PersonNotFoundException {
		assertEquals(FamilySearch.findPerson("Vyas").getName(), "Vyas");
	}

	@Test(expected = PersonNotFoundException.class)
	public void testFindPersonThrowException() throws PersonNotFoundException {
		FamilySearch.findPerson("Anil");
	}
}
