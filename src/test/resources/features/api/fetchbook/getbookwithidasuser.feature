Feature: Search book in library system as User role with book id
@searchByIdAsUser
  Scenario: Searching book  in library as an user role

    When As an user fetch the book with its id.
    Then He should receive the book with title "Jenkins Tutorial"