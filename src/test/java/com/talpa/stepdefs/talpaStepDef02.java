package com.talpa.stepdefs;

import com.talpa.pages.talpaPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class talpaStepDef02 {
	talpaPages talpaOb = new talpaPages();
	
	@Given("Select data from second testcase")
	public void select_data_from_second_testcase() {
	    talpaOb.getSheetData("TC_02");
	}
	
	@When("User navigates to the URL")
	public void user_navigates_to_the_URL() {
	    talpaOb.launchTalpaDynamicURL();
	}

	@Then("User should observe three Unique IDs")
	public void user_should_observe_three_Unique_IDs() {
	    talpaOb.challengeValidation();
	}

	@When("user clicks on {string}")
	public void user_clicks_on(String string) {
	    talpaOb.clickID();
	}

	@Then("user should observe the expected answer")
	public void user_should_observe_the_expected_answer() {
	    talpaOb.finalAnswer();
	}

}
