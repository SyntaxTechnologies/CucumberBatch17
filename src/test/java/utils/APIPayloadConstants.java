package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String generateTokenPayload(){
        String generateToken = "{\n" +
                "  \"email\": \"tests@batch17.com\",\n" +
                "  \"password\": \"Tests@123\"\n" +
                "}";
        return generateToken;
    }


    public static String createEmployeePayload(){
       String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"hind\",\n" +
                "  \"emp_lastname\": \"pak\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2002-11-25\",\n" +
                "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"qa\"\n" +
                "}";
       return createEmployeePayload;
    }

    public static String createEmployeeJsonPayload(){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","hind");
        obj.put("emp_lastname","pak");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2002-11-25");
        obj.put("emp_status","confirmed");
        obj.put("emp_job_title","qa");

        return obj.toString();
    }



}
