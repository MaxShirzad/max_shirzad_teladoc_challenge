package com.teladoc.step_definitions;

import com.github.javafaker.Faker;
import com.teladoc.pages.WebTablePage;
import com.teladoc.utilities.BrowserUtilities;
import com.teladoc.utilities.ConfigurationReader;
import com.teladoc.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebTable_StepDefinitions {

    WebTablePage tablePage = new WebTablePage();

    Faker faker = new Faker();
    String newUserFirstName = faker.name().firstName();
    String newUserLastName =faker.name().lastName();
    String newUserUserName = newUserLastName.toLowerCase();
    String newUserPassword = faker.internet().password();
    String newUserEmail = newUserFirstName.substring(0,1)+ newUserLastName
            +"@" +faker.internet().domainName();
    String newUserPhone = faker.phoneNumber().cellPhone();


    @Given("admin is on the page")
    public void admin_is_on_the_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("admin adding a new user")
    public void admin_adding_a_new_user() {
        tablePage.addUserButton.click();
        tablePage.addUserFirstName.sendKeys(newUserFirstName);
        tablePage.addUserLastName.sendKeys(newUserLastName);
        tablePage.addUserUserName.sendKeys(newUserUserName);
        tablePage.addUserPassword.sendKeys(newUserPassword);
        tablePage.addUserCompanyARadio.click();
        Select select = new Select(tablePage.addUserRoleId);
        select.selectByIndex(2);
        tablePage.addUserEmail.sendKeys(newUserEmail);
        tablePage.addUserMobilePhone.sendKeys(newUserPhone);
        tablePage.saveNewUserButton.click();
    }

    @Then("admin validating the new user has been added to the table")
    public void admin_validating_the_new_user_has_been_added_to_the_table() {
        List<WebElement> allFirstNamesElement= tablePage.allFirstNamesFromTable;
        List<String> allFirstNames = BrowserUtilities.getElementsText(allFirstNamesElement);
        Assert.assertTrue(allFirstNames.contains(newUserFirstName));

        List<String> allEmails = BrowserUtilities.getElementsText(tablePage.allUserEmailsFromTable);
        Assert.assertTrue(allEmails.contains(newUserEmail));

        List<String> allLastNames = BrowserUtilities.getElementsText(tablePage.allLastNamesFromTable);
        Assert.assertTrue(allLastNames.contains(newUserLastName));

        List<String> allCellPhones = BrowserUtilities.getElementsText(tablePage.allUserCellsFromTable);
        Assert.assertTrue(allCellPhones.contains(newUserPhone));



    }

    @When("admin deleting user User Name: {string}")
    public void admin_deleting_user_user_name(String userName) {
        tablePage.deleteUserButton(userName).click();
        tablePage.confirmationToDeleteButton.click();
    }

    @Then("admin validating the user {string} has been deleted")
    public void admin_validating_the_user_has_been_deleted(String userName) {
        List<String> allUserNames = BrowserUtilities.getElementsText(tablePage.allUserNamesFromTable);
        Assert.assertTrue(!allUserNames.contains(userName));

    }
}