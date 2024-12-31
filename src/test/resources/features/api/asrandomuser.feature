
Feature: Search book list in library system as Random User role

  Scenario: Searching book list in library as a random user role
    Given The library get book list API is available and running for authorized user
    When As a random user fetch the book list
    Then He should receive unauthorized code 401