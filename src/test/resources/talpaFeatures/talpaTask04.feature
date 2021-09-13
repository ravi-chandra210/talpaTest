@TestCase04
Feature: Downloading File

Scenario Outline: User should the file in the required format
Given Select the URL from excel sheet
Given user navigates to the file download URL
When User clicks on Enabled
Then list is displayed and click on Downloads
Then file format is displayed and click on required "<format>"
Then file should be downloaded in selected format

Examples:
			|format|
			|PDF|
			|CSV|
			|Excel|