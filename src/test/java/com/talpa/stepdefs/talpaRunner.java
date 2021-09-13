package com.talpa.stepdefs;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features={"src/test/resources/talpaFeatures"}, tags = {"@TestCase01,@TestCase02,@TestCase04"}, monochrome=true)
@CucumberOptions(features={"src/test/resources/talpaFeatures/talpaTask02.feature"}, monochrome=true)

public class talpaRunner {

//	plugin = {"pretty", "html:target/cucumber-reports"}, 
}
