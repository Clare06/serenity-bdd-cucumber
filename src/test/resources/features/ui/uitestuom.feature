@ui
Feature: Select Instagram

  @green
  Scenario: Navigating to instagram page
    Given Shakila is in UOM IT Faculty page
    When he clicks Instagram icon
    Then he should see instagram url "https://www.instagram.com/"
#    Then he should see instagram url "https://www.flickr.com/photos/university-of-moratuwa/"