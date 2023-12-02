Feature: Syntax API workflow feature

  @api
  Scenario: create an employee via API
    Given a JWT is generated
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for this request is 201
