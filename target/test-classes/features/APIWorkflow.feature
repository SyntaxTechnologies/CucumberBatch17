Feature: Syntax API workflow feature

  Background:
    Given a JWT is generated

  @api
  Scenario: create an employee via API
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for other request

    @api
    Scenario: get the created employee
      Given a request is prepared to get the created employee
      When a GET call is made to get the employee
      Then the status code for this employee is 200
      And the global employee id must match with "employee.employee_id" key
      And the retrieved data at "employee" object matches the data used to create employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |hind         |pak         |ms            |Male      |2002-11-25  |confirmed |QA           |

