Feature: Delete a book from the database

  Scenario Outline: Deleting book with different roles
    When I delete the book as a "<role>"
    Then I should receive delete "<outcome>"

    Examples:
      | role              | outcome                 |
      | admin             | status code 200         |
      | user              | forbidden 403           |
      | unauthorized user | unauthorized code 401   |
