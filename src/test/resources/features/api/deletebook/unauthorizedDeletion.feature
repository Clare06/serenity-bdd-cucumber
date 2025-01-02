Feature: Delete a book in the library system

  Scenario Outline: Attempting to delete a book with different roles
    Given The library delete book API is available
    When I try to delete a book as a "<role>"
    Then I should receive "<outcome>" for delete attempt

    Examples:
      | role              | outcome   |
      | admin             | success   |
      | user              | 401       |
      | unauthorized user | 401       |
