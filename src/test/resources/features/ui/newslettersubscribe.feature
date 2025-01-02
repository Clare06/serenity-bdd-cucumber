Feature: Verify Newsletter Subscription

  @newsletter
  Scenario: Check newsletter subscription functionality
    Given Komuthu wants to subscribe to the IT Faculty newsletter
    When he enters "test@example.com" in the subscription field
    And he clicks the Subscribe button
    Then he should be redirected to the 404 error page

