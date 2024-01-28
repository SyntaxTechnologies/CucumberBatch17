package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

   // public WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws InterruptedException {
      //  driver = new ChromeDriver();
     //   driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
       // Thread.sleep(2000);
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openBrowserAndLaunchApplication();
    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() throws InterruptedException {
        //object of the login page class to access all the web elements
     //   LoginPage lp = new LoginPage();
       // WebElement usernameTextField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
    //    usernameTextField.sendKeys("admin");
      //  Thread.sleep(2000);
        sendText(loginPage.usernameTextField, ConfigReader.read("username"));
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //   WebElement passwordTextField = driver.findElement(By.cssSelector("input#txtPassword"));
        sendText(loginPage.passwordTextField, ConfigReader.read("password"));
       // passwordTextField.sendKeys("Hum@nhrm123");

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
       // LoginPage lp = new LoginPage();
        //WebElement loginButton = driver.findElement(By.xpath("//*[@value='LOGIN']"));
        click(loginPage.loginBtn);
    //    loginButton.click();
    //    Thread.sleep(2000);
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
       // System.out.println(1/0);
       // System.out.println("My test passed");
        //assertions to check if the element exist
        //the moment assertion finds an error, it stops the execution
        //assert true, it is a boolean condition we write to check if it returns true or false
        Assert.assertTrue(dashboardPage.welcomeAdminLocator.isDisplayed());
      //  System.out.println(1/0);
      //  Assert.assertEquals();
    }
}
