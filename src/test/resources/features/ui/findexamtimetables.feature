@ui
Feature: Hover over dropdown and select an option

  Scenario: User selects an option from the dropdown
    Given "Gimhani" is in UOM IT Faculty page
    When the user hovers over the "Divisions" menu
    And selects "Undergraduate Studies" from the dropdown
    Then the user should be navigated to the "Division of Undergraduate Studies - Faculty of Information Technology | University of Moratuwa" page
    When the user hovers over the "Schedules" menu
    And selects "Exam TimeTables" from the dropdown
    Then She should see the url contains "https://uom.lk/itfac/ugs/exam-timetables"
