Feature: Delete a book from the database

  Scenario Outline: Deleting book with different roles
    When I delete the book as a "<role>"
    Then I should receive delete "<outcome>"

    Examples:
      | role              | outcome                 |
      | admin             | status 200              |
      | user              | forbidden 403           |
      | unauthorized      | unauthorized 401        |


    Scenario: Delete a nonexistent book
      When I delete a nonexistent book
      Then I should receive delete "not found 404"
