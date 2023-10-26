Feature: Employee search

  Background:
   # Given user is navigated to HRMS application
    * user enters admin username and password
    * user clicks on login button
    * user is successfully logged in
    * user clicks on PIM option
    * user clicks on Employee List option

  @sprint2 @ahmed @regression @emp @test123
  Scenario: Search an employee by Id
  #  Given user is navigated to HRMS application
  #  When user enters admin username and password
  #  And user clicks on login button
  #  Then user is successfully logged in
  #  When user clicks on PIM option
  #  And user clicks on Employee List option
    * user enters employee id
    * user clicks on search button
    * user should be able to see employee details
    #Then user closes the browser

  @sprint4 @ali @regression @emp
  Scenario: Search an employee by name
    #Given user is navigated to HRMS application
   # When user enters admin username and password
    #And user clicks on login button
   # Then user is successfully logged in
   # When user clicks on PIM option
    #And user clicks on Employee List option
    * user enters valid employee name
    * user clicks on search button
    * user should be able to see employee details
    #Then user closes the browser


