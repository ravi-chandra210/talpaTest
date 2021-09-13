package com.talpa.stepdefs;

import com.talpa.pages.talpaPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class talpaStepDef04 {
	talpaPages talpaOb = new talpaPages();
	@Given("Select the URL from excel sheet")
	public void select_the_URL_from_excel_sheet() {
		talpaOb.getSheetData("TC_04");
	}

	@Given("user navigates to the file download URL")
	public void user_navigates_to_the_file_download_URL() {
	    talpaOb.launchTalpaDynamicURL();
	}

	@When("User clicks on Enabled")
	public void user_clicks_on_Enabled() {
	    talpaOb.fileEnabled();
	}

	@Then("list is displayed and click on Downloads")
	public void list_is_displayed_and_click_on_Downloads() {
	    talpaOb.fileDownload();
	}

	@Then("file format is displayed and click on required {string}")
	public void file_format_is_displayed_and_click_on_required(String fileFormat) {
	    talpaOb.formatDownload(fileFormat);
	}

	@Then("file should be downloaded in selected format")
	public void file_should_be_downloaded_in_selected_format() throws InterruptedException {
		talpaOb.closeBrowser();
	    
	}

}
