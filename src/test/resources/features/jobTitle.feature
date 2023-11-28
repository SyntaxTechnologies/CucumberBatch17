Feature: add job Title feature

  Background:
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in

    @jobTitle1
    Scenario: add  new job Title
      When user clicks on admin button
      And user clicks on Job button
      And user clicks on Job Title button
      And user clicks on Add Button
      And user enters jobTitle "SDET12346" desc "Automating  and testing website" note "Exceptional well"
      And user clicks on the save button
      And verify same info from backend
