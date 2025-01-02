Feature: Navigate to Research Unit Page

  @research
  Scenario: Clicking the More button on the Research page
    Given Nadun is on the Research page of the UOM website
    When he clicks the More button
    Then he should be redirected to the URL "https://uom.lk/itfac/research/research-unit"
    And the page should contain the heading "Information Technology Research Unit"