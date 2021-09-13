@TestCase01
Feature: Click start for every example and observe the appeared elements

Background: User navigates to Dynamically Loaded Page Elements
Given Load test data from testcase
When User navigates to the URL
Then User should observe two Example URLs

Scenario: First Example
Given When user click on the first example URL
Then user should navigate to Example 1 page and click Start
Then Hello World! text should be displayed after loading bar is completed

Scenario: Second Example
Given When user click on the second example URL
Then user should navigate to Example 2 page and click Start
Then Hello World! text should be displayed after loading bar is completed