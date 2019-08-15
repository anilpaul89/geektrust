package me.anil.geektrust.lengaburu.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.anil.geektrust.lengaburu.LengaburuMainLoader;
import me.anil.geektrust.lengaburu.exception.PersonNotFoundException;
import me.anil.geektrust.lengaburu.model.LengaburuModel;
import me.anil.geektrust.lengaburu.model.Person;

public class RelationshipFinderServiceTest {

	private RelationshipFinderService relationShipService;

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
		this.relationShipService = new RelationshipFinderService();
	}

	@Test
	public void testFindUncles() throws PersonNotFoundException {
		List<Person> uncles = this.relationShipService.findUncles(LengaburuModel.getLengaburuModel().getMember("Vasa"),
				false);
		assertEquals(1, uncles.size());
		assertEquals("Vyas", uncles.get(0).getName());

	}

	@Test
	public void testFindAunts() throws PersonNotFoundException {
		List<Person> aunts = this.relationShipService.findAunts(LengaburuModel.getLengaburuModel().getMember("Tritha"),
				true);
		assertEquals(0, aunts.size());

	}

	@Test
	public void testFindSon() throws PersonNotFoundException {
		List<Person> sons = this.relationShipService.findSon(LengaburuModel.getLengaburuModel().getMember("Krpi"));
		assertEquals(1, sons.size());
		assertEquals("Kriya", sons.get(0).getName());
	}

	@Test
	public void testFindDaughter() throws PersonNotFoundException {
		List<Person> daughters = this.relationShipService
				.findDaughter(LengaburuModel.getLengaburuModel().getMember("Krpi"));
		assertEquals(1, daughters.size());
		assertEquals("Krithi", daughters.get(0).getName());
	}

	@Test
	public void testFindSiblings() throws PersonNotFoundException {
		List<Person> siblings = this.relationShipService
				.findSiblings(LengaburuModel.getLengaburuModel().getMember("Vasa"));
		assertEquals(0, siblings.size());
	}

	@Test
	public void testFindBrotherInLaw() throws PersonNotFoundException {
		List<Person> inlaws = this.relationShipService
				.findBrotherInLaw(LengaburuModel.getLengaburuModel().getMember("Tritha"));
		assertEquals(1, inlaws.size());
		assertEquals("Jaya", inlaws.get(0).getName());
	}

	@Test
	public void testFindSisterInLaws() throws PersonNotFoundException {
		List<Person> inLaws = this.relationShipService
				.findSisterInLaw(LengaburuModel.getLengaburuModel().getMember("Atya"));
		assertEquals(2, inLaws.size());
	}
}
