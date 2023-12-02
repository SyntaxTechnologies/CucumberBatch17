package API;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    //in rest assured base uri = base URL
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE1MzIwNDIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTU3NTI0MiwidXNlcklkIjoiNjA3NyJ9.fH-5ITwDjpYGkQIcM_ttUe7Ob13u_Hp8K4uxrB4NriQ";
    static String employee_id;

    @Test
    public void acreateEmployee(){
        //prepare the request
       //request specification allows us to prepare the request and gives it in variable
       RequestSpecification request = given().header("Content-Type","application/json").
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

        //send the request for creating the employee
        //response is the class which holds the complete response body and the info
        Response response =  request.when().post("/createEmployee.php");

        //to print the response in console
        response.prettyPrint();

        //validate the response status
        response.then().assertThat().statusCode(201);
        //validate the body
        response.then().assertThat().
                body("Message", equalTo("Employee Created"));
        response.then().assertThat().
                body("Employee.emp_firstname",equalTo("hind"));
        response.then().assertThat().
                header("Connection",equalTo("Keep-Alive"));
        //to store the employee id after generating the employee
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
    }

    @Test
    public void bgetCreatedEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //validate the employee id's one from post call another from get call
        String tempEmpId = response.jsonPath().
                getString("employee.employee_id");

        Assert.assertEquals(tempEmpId, employee_id);
    }

    @Test
    public void cUpdateEmployee(){
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"rakhima\",\n" +
                        "  \"emp_lastname\": \"bhujbal\",\n" +
                        "  \"emp_middle_name\": \"simonov\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2001-11-09\",\n" +
                        "  \"emp_status\": \"struggling\",\n" +
                        "  \"emp_job_title\": \"survivor\"\n" +
                        "}");
        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void dgetupdatedEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //validate the employee id's one from post call another from get call
        String tempEmpId = response.jsonPath().
                getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);
    }

}
