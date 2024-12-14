Feature: Search book list in library

  Scenario: Searching book list
    Given The library API is available
    When I fetch the book list
    Then I should receive a list of books