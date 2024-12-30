Feature: Search by keyword

  @red
  Scenario: Searching for 'faculty'
    Given Komuthu is researching things on UOM website
    When he looks up "faculty"
    Then he should see information about "roles for individuals with a PhD in materials …  ongoing projects, and funding opportunities."