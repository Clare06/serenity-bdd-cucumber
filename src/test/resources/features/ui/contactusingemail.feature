@ui
  Feature: Contact the faculty using email
    
    Scenario: User go to contact us page
      Given Shakila is in UOM IT Faculty page
      When the user hovers over the "About us" menu
      And selects "Contact Us" from the dropdown
      Then the user should be navigated to the "Contact Us | University of Moratuwa" page
      When he clicks on the email link
      Then the email app should open