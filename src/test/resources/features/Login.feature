Feature: Login scenarios

  @sprint1 @nafiseh @regression @test12345 @smoke
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    #Then user closes the browser


  @smoke
  Scenario: Valid admin logincred
    #Given user is navigated to HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    #Then user closes the browser
