Feature: Admin updates book name

  Scenario: Admin updates the book name
    Given The library update book name API is available
    When I update the book name to "New Book Title" as an "admin"
    Then I should receive a success message confirming the book name is updated