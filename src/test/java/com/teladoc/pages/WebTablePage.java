package com.teladoc.pages;

import com.teladoc.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablePage {

    public WebTablePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button[type='add']")
    public WebElement addUserButton;

    @FindBy(css = "[name='FirstName']")
    public WebElement addUserFirstName;

    @FindBy(css = "[name='LastName']")
    public WebElement addUserLastName;

    @FindBy(css = "[name='UserName']")
    public WebElement addUserUserName;

    @FindBy(css = "[name='Password']")
    public WebElement addUserPassword;

    @FindBy(css = "[name='Email']")
    public WebElement addUserEmail;

    @FindBy(css = "[name='RoleId']")
    public WebElement addUserRoleId;

    @FindBy(css = "[name='Mobilephone']")
    public WebElement addUserMobilePhone;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement addUserCompanyARadio;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement addUserCompanyBRadio;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveNewUserButton;

    @FindBy(xpath = "//table[@table-title='Smart Table example']/tbody//tr/td[1]")
    public List<WebElement> allFirstNamesFromTable;

    @FindBy(xpath = "//table[@table-title='Smart Table example']/tbody//tr/td[2]")
    public List<WebElement> allLastNamesFromTable;

    @FindBy(xpath = "//table[@table-title='Smart Table example']/tbody//tr/td[3]")
    public List<WebElement> allUserNamesFromTable;

    @FindBy(xpath = "//table[@table-title='Smart Table example']/tbody//tr/td[7]")
    public List<WebElement> allUserEmailsFromTable;

    @FindBy(xpath = "//table[@table-title='Smart Table example']/tbody//tr/td[8]")
    public List<WebElement> allUserCellsFromTable;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement confirmationToDeleteButton;


    public WebElement deleteUserButton(String userName){
      return  Driver.getDriver().findElement(
                By.xpath("//td[.='" + userName +"']/..//i[@class='icon icon-remove']"));

    }
}
