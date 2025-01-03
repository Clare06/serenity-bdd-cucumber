@ui
Feature: Download UOM Account Request Form

  Scenario: Downloading the UOM Account Request Form
    Given Nadun is on the UOM Cites page
    When he checks the checkbox
    Then he can see the download button
    Then he clicks the "Download UOM Account Request Form" button
    And the "UOM-account-request-form.doc" file should be downloaded to the computer