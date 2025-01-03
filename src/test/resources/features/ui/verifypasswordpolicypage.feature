@ui
Feature: Verify Correct Table Heading Formatting in Password Policy Page

  @passwordpolicy
  Scenario: Check if the table heading in the Password Policy page is correctly formatted
    Given Komuthu is in the UOM Password Policy page
    Then he should verify that all table headings are correctly formatted
