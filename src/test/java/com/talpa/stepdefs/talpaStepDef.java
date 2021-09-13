package com.talpa.stepdefs;

import com.talpa.pages.talpaPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class talpaStepDef {
	talpaPages talpaOb = new talpaPages();
	
	@Given("Load test data from testcase")
	public void load_test_data_from_testcase() {
	    talpaOb.getSheetData("TC_01");
	}
	
	@When("When User navigates to the URL")
	public void User_navigates_to_the_URL() {
	    talpaOb.launchTalpaDynamicURL();
	}

	@Then("User should observe two Example URLs")
	public void user_should_observe_two_Example_URLs() {
	    talpaOb.dynamicValidation();
	}

	@Given("When user click on the first example URL")
	public void when_user_click_on_the_first_example_URL() {
	    talpaOb.example01();
	}

	@Then("user should navigate to Example {int} page and click Start")
	public void user_should_navigate_to_Example_page_and_click_Start(Integer int1) {
	    talpaOb.Start();
	}

	@Then("Hello World! text should be displayed after loading bar is completed")
	public void hello_World_text_should_be_displayed_after_loading_bar_is_completed() {
	    talpaOb.finalResult();
	}

	@Given("When user click on the second example URL")
	public void when_user_click_on_the_second_example_URL() {
	    talpaOb.example02();
	}

}
