package me.anil.geektrust.lengaburu.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.anil.geektrust.lengaburu.LengaburuMainLoader;
import me.anil.geektrust.lengaburu.exception.PersonNotFoundException;
import me.anil.geektrust.lengaburu.model.Person;
import me.anil.geektrust.lengaburu.search.FamilySearch;

public class RelationshipFinderServiceTest {

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
	}

	@Test
	public void testFindUncles() throws PersonNotFoundException {
		List<Person> uncles = RelationshipFinderService.findUncles(FamilySearch.findPerson("Vasa"), false);
		assertEquals(1, uncles.size());
		assertEquals("Vyas", uncles.get(0).getName());

	}

	@Test
	public void testFindAunts() throws PersonNotFoundException {
		List<Person> aunts = RelationshipFinderService.findAunts(FamilySearch.findPerson("Tritha"), true);
		assertEquals(0, aunts.size());

	}

	@Test
	public void testFindSon() throws PersonNotFoundException {
		List<Person> sons = RelationshipFinderService.findSon(FamilySearch.findPerson("Krpi"));
		assertEquals(1, sons.size());
		assertEquals("Kriya", sons.get(0).getName());
	}

	@Test
	public void testFindDaughter() throws PersonNotFoundException {
		List<Person> daughters = RelationshipFinderService.findDaughter(FamilySearch.findPerson("Krpi"));
		assertEquals(1, daughters.size());
		assertEquals("Krithi", daughters.get(0).getName());
	}

	@Test
	public void testFindSiblings() throws PersonNotFoundException {
		List<Person> siblings = RelationshipFinderService.findSiblings(FamilySearch.findPerson("Vasa"));
		assertEquals(0, siblings.size());
	}

	@Test
	public void testFindBrotherInLaw() throws PersonNotFoundException {
		List<Person> inlaws = RelationshipFinderService.findBrotherInLaw(FamilySearch.findPerson("Tritha"));
		assertEquals(1, inlaws.size());
		assertEquals("Jaya", inlaws.get(0).getName());
	}

	@Test
	public void testFindSisterInLaws() throws PersonNotFoundException {
		List<Person> inLaws = RelationshipFinderService.findSisterInLaw(FamilySearch.findPerson("Atya"));
		assertEquals(2, inLaws.size());
	}
}
