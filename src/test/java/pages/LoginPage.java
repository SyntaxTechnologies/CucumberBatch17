package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(id="txtUsername")
    public WebElement usernameTextField;

    @FindBy(id="txtPassword")
    public WebElement passwordTextField;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    public LoginPage(){
        //our this code will initialize all the elements of the page
        //because when the object creates, constructor will be called which will
        //initialize all of these elements
        PageFactory.initElements(driver, this);
    }



}
