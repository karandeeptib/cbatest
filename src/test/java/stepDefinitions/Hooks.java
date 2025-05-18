package stepDefinitions;

import io.cucumber.java.After;

public class Hooks {
	
	@After
	static void tearDownAll() {
		PetStepDefinition.petid=null;
	}
}
