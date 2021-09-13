@TestCase03
Feature: Sorting lists in table and Downloading File

Scenario: TC_03--User should sort the lists in table by clicking the headers.
Given url is selected from the sheet provided
When user clicks on any of the header in table
Then list is sorted either ascending or descending