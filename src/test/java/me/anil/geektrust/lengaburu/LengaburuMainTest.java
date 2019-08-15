package me.anil.geektrust.lengaburu;

import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import me.anil.geektrust.lengaburu.commands.AddChildProcessTest;
import me.anil.geektrust.lengaburu.commands.AddSpouseProcessTest;
import me.anil.geektrust.lengaburu.commands.GetRelationShipProcessTest;
import me.anil.geektrust.lengaburu.model.LengaburuModelTest;
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
		Result result = JUnitCore.runClasses(RelationshipFinderServiceTest.class, LengaburuModelTest.class,
				GetRelationShipProcessTest.class, AddSpouseProcessTest.class, AddChildProcessTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}

}
