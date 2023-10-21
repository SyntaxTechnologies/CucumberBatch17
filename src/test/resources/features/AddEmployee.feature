Feature: add employee scenario

  Background:
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option

  @addemp @test
  Scenario: Adding one employee in the hrms system
    #Given user is navigated to HRMS application
    #When user enters admin username and password
   # And user clicks on login button
    #Then user is successfully logged in
    #When user clicks on PIM option
    #And user clicks on add employee option
    When user enters firstName middleName and lastName
    And user clicks on save button
    Then employee added successfully
   # Then user closes the browser


  @cucumber
  Scenario: Adding one employee using feature file
   # When user enters admin username and password
   # And user clicks on login button
   # Then user is successfully logged in
   # When user clicks on PIM option
   # And user clicks on add employee option
    When user enters "miraj" and "fali" and "moralejo"
    And user clicks on save button
    Then employee added successfully

  @ddt
  Scenario Outline: adding multiple employees from feature file
    When user enters "<firstName>" and "<middleName>" and enters "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      |donal      |ms          |duck      |
      |tamoha     |ms          |jimo      |
      |joe        |ms          |trump     |




