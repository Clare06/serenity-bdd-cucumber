@ui
Feature: Verify Home Page Loads Correctly

  @homepage
  Scenario: Check if the IT Faculty homepage loads correctly
    Given Komuthu is in UOM IT Faculty page
    When he opens the IT Faculty homepage
    Then he should see the title "Faculty of Information Technology | University of Moratuwa"
    And he the main banner should be displayed
    And he the navigation menu should contain "IT-HOME, ABOUT US, DEPARTMENTS, PEOPLE, EDUCATION, DIVISIONS"
