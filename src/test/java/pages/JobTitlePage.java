package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class JobTitlePage extends CommonMethods {
    @FindBy(xpath = "//input[@id='btnAdd']")
    public WebElement addJobBtn;

    @FindBy(xpath = "//input[@id='jobTitle_jobTitle']")
    public WebElement addJobTitleField;


    @FindBy(xpath = "//textarea[@id='jobTitle_jobDescription']")
    public WebElement addJobDesc;

    @FindBy(xpath = "//textarea[@id='jobTitle_note']")
    public WebElement addJobNote;


    @FindBy(xpath = "//a[@id='menu_admin_viewJobTitleList']")
    public  WebElement jobTitleButton;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement addJobSvBtn;

    public JobTitlePage(){
        PageFactory.initElements(driver,this);
    }

}