Feature: Search book in library system by book id

  Scenario Outline: Searching book in library with different roles
    When As a "<role>", fetch the book with its id
    Then He should receive "<outcome>"

    Examples:
      | role            | outcome                               |
      | user            | the book with title Jenkins Tutorial  |
      | admin           | the book with title Jenkins Tutorial  |
      | unauthorized    | unauthorized code 401                 |
