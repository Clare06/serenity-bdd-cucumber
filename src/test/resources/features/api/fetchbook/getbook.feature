#Feature: Search book list in library system
#
#  @RandomUser
#  Scenario: Searching book list in library as a random user role
#    Given The library get book list API is available
#    When As a random user fetch the book list
#    Then He should receive unauthorized code 401
#
#  @Admin
#  Scenario: Searching book list in library system as an admin
#    Given The library get book list API is available
#    When I fetch the book list
#    Then I should receive a list of books
#
#  @User
#  Scenario: Searching book list in library as a user role
#    Given The library get book list API is available
#    When As an user fetch the book list
#    Then He should receive a list of books

Feature: Search book list in library system

  Scenario Outline: Fetching book list with different roles
    Given The library get book list API is available
    When I fetch the book list as a "<role>"
    Then I should receive "<outcome>"

    Examples:
      | role              | outcome                     |
      | admin             | a list of books             |
      | user              | a list of books             |
      | unauthorized user | unauthorized code 401       |
