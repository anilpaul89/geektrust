package me.anil.geektrust.lengaburu.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import me.anil.geektrust.lengaburu.LengaburuMainLoader;
import me.anil.geektrust.lengaburu.exception.ChildAdditionException;
import me.anil.geektrust.lengaburu.exception.PersonNotFoundException;
import me.anil.geektrust.lengaburu.search.FamilySearch;

public class AddMemberServiceTest {

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
	}

	@Test(expected = ChildAdditionException.class)
	public void testAddChildWithException() throws ChildAdditionException, PersonNotFoundException {
		AddMemberService.addChild(FamilySearch.findPerson("Vyas"), "Anil", "Male");
	}

	@Test
	public void testAddChild() throws ChildAdditionException, PersonNotFoundException {
		boolean isAdded = AddMemberService.addChild(FamilySearch.findPerson("Atya"), "Anil", "Male");
		assertEquals(true, isAdded);
	}

	@Test
	public void testAddSpouse() throws PersonNotFoundException {
		boolean isAdded = AddMemberService.addSpouse(FamilySearch.findPerson("Atya"), "Anil");
		assertEquals(true, isAdded);
	}
}
