package steps;

import com.sun.tools.jconsole.JConsoleContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
       // WebElement addEmployeeButton = driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']"));
        click(dashboardPage.addEmployeeButton);
    }

    @When("user enters firstName middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
      //  WebElement firstNameField = driver.findElement(By.id("firstName"));
      //  WebElement middleNameField = driver.findElement(By.id("middleName"));
      //  WebElement lastNameField = driver.findElement(By.id("lastName"));
        sendText(addEmployeePage.firstNameLoc, "nind");
        sendText(addEmployeePage.middleNameLoc, "esha");
        sendText(addEmployeePage.lastNameLoc, "lata");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
      //  WebElement saveBtn = driver.findElement(By.id("btnSave"));
        click(addEmployeePage.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
        closeBrowser();
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstN, String middleN, String lastN) {
      //  WebElement firstNameField = driver.findElement(By.id("firstName"));
      //  WebElement middleNameField = driver.findElement(By.id("middleName"));
      //  WebElement lastNameField = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameLoc, firstN);
        sendText(addEmployeePage.middleNameLoc, middleN);
        sendText(addEmployeePage.lastNameLoc, lastN);
    }

    @When("user enters {string} and {string} and enters {string}")
    public void user_enters_and_and_enters(String firstN, String middleN, String lastN) {
      //  WebElement firstNameField = driver.findElement(By.id("firstName"));
      //  WebElement middleNameField = driver.findElement(By.id("middleName"));
      //  WebElement lastNameField = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameLoc, firstN);
        sendText(addEmployeePage.middleNameLoc, middleN);
        sendText(addEmployeePage.lastNameLoc, lastN);
    }

    @When("user adds multiple employees from excel using {string} and verify them")
    public void user_adds_multiple_employees_from_excel_using_and_verify_them
            (String sheetName) throws InterruptedException {
       List<Map<String, String>> newEmployees =
               ExcelReader.read(sheetName, Constants.TESTDATA_FILEPATH);

        //from the list of maps, we need one map at one point of time
        // this iterator will give me one map to add one employee at a time
        Iterator<Map<String, String>> itr = newEmployees.iterator();
        //it checks whether we have values in map or not
        while (itr.hasNext()){
            //it will return the keys and the values of the map which we store in this
            // variable
            Map<String, String> employeeMap = itr.next();
            sendText(addEmployeePage.firstNameLoc, employeeMap.get("firstName"));
            sendText(addEmployeePage.middleNameLoc, employeeMap.get("middleName"));
            sendText(addEmployeePage.lastNameLoc, employeeMap.get("lastName"));
            sendText(addEmployeePage.photograph, employeeMap.get("Photograph"));
            if(!addEmployeePage.checkBox.isSelected()){
                 click(addEmployeePage.checkBox);
            }
            sendText(addEmployeePage.usernameEmp, employeeMap.get("Username"));
            sendText(addEmployeePage.passwordEmp, employeeMap.get("Password"));
            sendText(addEmployeePage.confirmPassword, employeeMap.get("confirmPassword"));
            click(addEmployeePage.saveBtn);
            Thread.sleep(2000);
            //because we want to add many employees
            click(dashboardPage.addEmployeeButton);
            Thread.sleep(2000);
            //verification of employee still pending
        }

    }
}
