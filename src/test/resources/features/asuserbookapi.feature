
Feature: Search book list in library as User role

  Scenario: Searching book list in library as an user role
    Given The get book list API is available and running
    When As an user fetch the book list
    Then He should receive a list of books