Feature: Search book in library system as User role with book id
@searchByIdAsUser
  Scenario: Searching book  in library as an user role
#    Given Given that book is available in library with title "Jenkins Tutorial" and author "Reyon"
    When As an user fetch the book with its id.
    Then He should receive the book with title "Jenkins Tutorial"