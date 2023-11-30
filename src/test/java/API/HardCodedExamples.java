package API;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class HardCodedExamples {

    //in rest assured base uri = base URL
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDEzMTMwNjMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTM1NjI2MywidXNlcklkIjoiNjA3NyJ9.ye9mRiwsWz5pZKL9_LyiROS3A0R6N4TyKZR_Bx-ajn4";

    public void createEmployee(){
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

        //validate the response
        response.then().assertThat().statusCode(201);
    }


}
