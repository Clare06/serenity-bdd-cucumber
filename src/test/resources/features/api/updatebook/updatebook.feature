#Feature: Admin updates book name
#
#  Scenario: Admin updates the book name
##    Given The library update book name API is available
#    When I update the book name to "New Book Title" as an "admin"
#    Then I should receive a success message confirming the book name is updated

Feature: Update a book in the library system

  Scenario Outline: Updating a book with different roles
    When I update a book with the following details:
      | title     | author     | role    |
      | <title>   | <author>   | <role>  |
    Then I should receive a response for update indicating "<outcome>"


    Examples:
      | title             | author    | role         | outcome                             |
      | Roboticx          | Sonic     | admin        | book updated successfully for admin |
      | Rabbit            | Reyon     | user         | forbidden 403                       |
      | Apex              | Einstien  | unauthorized | unauthorized code 401               |
