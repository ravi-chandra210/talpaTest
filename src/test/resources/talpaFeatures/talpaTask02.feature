@TestCase02
Feature: Click on each unique ID

Background: User navigates to Challenging DOM URL
Given Select data from second testcase
When User navigates to the URL
Then User should observe three Unique IDs

Scenario Outline: User should be able to click on all available unique ids
When user clicks on "<unique_ID>"
Then user should observe the expected answer

Examples:
			|unique_ID|
			|challengeE1|
			|challengeE2|
			|challengeE3|