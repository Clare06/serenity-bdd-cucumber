Feature: Look for telephone directory

  @red
  Scenario: Looking for telephone directory
    Given Gimhani is looking for telephone directory of academic staffs
    When She scrolls down and click telephone directory link
    Then She should see "Please click here for the internal user telephone directory" and current URL should be "https://uom.lk/telephone-directory"
    When She clicks here link
    Then She should see login page and warning message "Access denied. You must log in to view this page"
    When She gives her credentials clicks LOG IN button
    Then She should see the telephone directories pdf and header "Internal Telephone Directory"