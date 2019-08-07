package me.anil.geektrust.lengaburu;

import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import me.anil.geektrust.lengaburu.search.FamilySearchTest;
import me.anil.geektrust.lengaburu.service.AddMemberServiceTest;
import me.anil.geektrust.lengaburu.service.RelationshipFinderServiceTest;

/**
 * Unit test for simple App.
 */
public class LengaburuMainTest {

	@Before
	public void loadHierarchy() {
		LengaburuMainLoader.initializeFamliy();
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AddMemberServiceTest.class, RelationshipFinderServiceTest.class,
				FamilySearchTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}

}
