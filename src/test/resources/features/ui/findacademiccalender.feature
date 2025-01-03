@ui
Feature: Check the academic calender

  Scenario: User selects an option from the dropdown
    Given "Harini" is in UOM IT Faculty page
    When the user hovers over the "Divisions" menu
    And selects "Postgraduate Studies" from the dropdown
    Then the user should be navigated to the "POSTGRADUATE PROGRAMMES | University of Moratuwa" page
    When "Harini" clicks on academic calendar
    Then She should see the url contains "https://dms.uom.lk/s/JY5tcRR2g89ncGe?dir=undefined&openfile=40460036"
