Feature: Navigate to Courses Page

  @green
  Scenario: Navigating to the Courses page
    Given Nadun opens the home page
    When he clicks the Courses icon
    Then he should see the courses page URL "https://uom.lk/courses"