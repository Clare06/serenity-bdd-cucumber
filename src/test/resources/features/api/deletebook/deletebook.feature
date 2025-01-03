Feature: Delete a book from the database

  Scenario Outline: Deleting book with different roles
    When I delete the book as a "<role>"
    Then I should receive "<outcome>" for "<role>"

    Examples:
      | role              | outcome                 |
      | admin             | status 200              |
      | user              | forbidden 403           |
      | unauthorized      | unauthorized 401        |


    Scenario Outline: Delete a nonexistent book
      When I delete a nonexistent book as a "<role>"
      Then I should receive "<outcome>" for "<role>"

      Examples:
        | role              | outcome                 |
        | admin             | not found 404           |
        | user              | forbidden 403           |
        | unauthorized      | unauthorized 401        |

    
    Scenario Outline: Create a delete request without a book id
      When I delete a book without a providing a book id as a "<role>"
      Then I should receive "<outcome>" for "<role>"

      Examples:
        | role              | outcome                   |
        | admin             | bad request 400           |
        | user              | forbidden 403             |
        | unauthorized      | unauthorized 401          |