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
      |donal1      |ms          |duck      |
      |tamoha1     |ms          |jimo      |
      |joe1        |ms          |trump     |

    @excel
    Scenario: Adding multiple employees from excel file
      When user adds multiple employees from excel using "Sheet1" and verify them

    @datatable
    Scenario: adding multiple employees from data table
      When user adds multiple employees from data table
      |firstName   | middleName | lastName |
      |donal12      |ms          |duck      |
      |tamoha12     |ms          |jimo      |
      |joe12        |ms          |trump     |

      @db
      Scenario: Add Employee from Frontend and verify from DB
        When user enters "fahim" and "Naughty" and "Hedaiy"
        And user clicks on save button
        Then employee added successfully
        And fetch employee info from backend
        Then verify employee info is properly stored in db









