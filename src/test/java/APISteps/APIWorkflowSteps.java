package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIWorkflowSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;
    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification request = given().
                header("Content-Type","application/json").
                body("{\n" +
                        "  \"email\": \"tests@batch17.com\",\n" +
                        "  \"password\": \"Tests@123\"\n" +
                        "}");
        Response response = request.when().post("/generateToken.php");
        //storing the token after generating it
       token = "Bearer "+ response.jsonPath().getString("token");
       System.out.println(token);
    }

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
         request = given().header("Content-Type","application/json").
                header("Authorization", token)
                .body("{\n" +
                        "  \"emp_firstname\": \"hind\",\n" +
                        "  \"emp_lastname\": \"pak\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2002-11-25\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"qa\"\n" +
                        "}");
    }

    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response =  request.when().post("/createEmployee.php");
        //to print the response in console
        response.prettyPrint();
    }

    @Then("the status code for this request is {int}")
    public void the_status_code_for_this_request_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        //validate the body
        response.then().assertThat().
                body("Message", equalTo("Employee Created"));
        response.then().assertThat().
                body("Employee.emp_firstname",equalTo("hind"));
        response.then().assertThat().
                header("Connection",equalTo("Keep-Alive"));
    }

    @Then("the employee id {string} is stored as global variable for other request")
    public void the_employee_id_is_stored_as_global_variable_for_other_request
            (String empId) {
        //empId is the parameter coming from feature file which is the path of employee id
        employee_id = response.jsonPath().getString(empId);
        System.out.println(employee_id);
    }


}
