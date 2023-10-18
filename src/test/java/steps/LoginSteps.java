package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {

   // public WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        Thread.sleep(2000);
    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() throws InterruptedException {
        WebElement usernameTextField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        usernameTextField.sendKeys("admin");
        Thread.sleep(2000);
        WebElement passwordTextField = driver.findElement(By.cssSelector("input#txtPassword"));
        passwordTextField.sendKeys("Hum@nhrm123");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//*[@value='LOGIN']"));
        loginButton.click();
        Thread.sleep(2000);
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("My test passed");
    }
}
