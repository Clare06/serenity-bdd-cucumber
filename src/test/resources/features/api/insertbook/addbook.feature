#Feature: Add a book to the system
#  This feature adds a book and verifies that it was added successfully.
#
#  Scenario: Add a book to the system
#    Given Add book API is available and running
#    When a book with the title "Cucumber for Beginners" and author "Harini" added to system
#    Then the book with title "Cucumber for Beginners" should exist in the system


##  @Cleanup
##  Scenario: Cleanup database
##    Given the database is not empty
##    When I remove all books
##    Then the database should be empty
Feature: Add a book to the library system

  Scenario Outline: Adding a book with different roles
    When I add a book with the following details:
      | title             | author     | role              |
      | <title>           | <author>   | <role>            |
    Then I should receive a response indicating "<outcome>"

    Examples:
      | title             | author   | role             | outcome                          |
      | API Design        | Martin   | admin            | book added successfully for admin|
      | Testing Patterns  | Fowler   | user             | book added successfully for user |
      | Unauthorized Book | Unknown  | unauthorized user| unauthorized code 401            |
