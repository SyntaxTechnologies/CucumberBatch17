package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

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
}
