package com.symund.step_definitions;

import com.symund.page.LoginPage;
import com.symund.page.MainPage;
import com.symund.page.PasswordResetPage;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginFunc_StepDefinitions {

        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        PasswordResetPage resetPage = new PasswordResetPage();

    String expectedTitle = "Dashboard - Symund - QA";

    @Given("user navigates to the symund login page")
    public void user_navigates_to_the_symund_login_page() {
        Driver.getDriver().get("https://qa.symund.com/");
    }

    @When("user leaves {string} in username")
    public void user_leaves_in_username(String string) {
            loginPage.username.sendKeys(string);
    }

    @When("user leaves {string} in password")
    public void user_leaves_in_password(String string) {
            loginPage.password.sendKeys(string);
    }

    @When("user clicks login button")
    public void user_should_be_able_to_click_login_button() {
            loginPage.loginBtn.click();
    }

    @Then("verify that user can login")
    public void verify_that_user_can_login() {
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    @Then("verify that user cannot login with invalid credentials and can see wrong username or password")
    public void verify_that_user_cannot_login_with_invalid_credentials_and_can_see_wrong_username_or_password() {
        if (Driver.getDriver().getTitle().equals("Symund - QA")) {
            Assert.assertTrue(loginPage.message.isDisplayed());
        } else {
            Assert.assertEquals("Symund - QA", Driver.getDriver().getTitle());
        }
    }

    @Then("verify that user sees the password in a form of dots by default")
    public void verify_that_user_sees_the_password_in_a_form_of_dots_by_default() {
       Assert.assertEquals("password",loginPage.password.getAttribute("type"));
    }

    @When("user clicks button that shows password")
    public void user_clicks_button_that_shows_password() {
        loginPage.toggleSwitch.click();
    }

    @Then("verify that user can see password")
    public void verifyThatUserCanSeePassword() {
        Assert.assertEquals("text",loginPage.password.getAttribute("type"));
    }

    @When("user clicks forgot password button")
    public void user_clicks_forgot_password_button() {
        loginPage.forgotPasswordBtn.click();
    }
    @Then("verify that user can reset the password")
    public void verify_that_user_can_reset_the_password() {
        Assert.assertTrue(resetPage.userInput.isDisplayed());
    }


    @Then("verify that {string} as default in username placeholder")
    public void verifyThatAsDefaultInUsernamePlaceholder(String arg0) {
        Assert.assertEquals(arg0,loginPage.username.getAttribute("placeholder"));
    }

    @Then("verify that {string} as default in password placeholder")
    public void verifyThatAsDefaultInPasswordPlaceholder(String arg0) {
        Assert.assertEquals(arg0,loginPage.password.getAttribute("placeholder"));
    }

    @And("user leaves {string} in mail input")
    public void userLeavesInMailInput(String arg0) {
    }

    @And("user clicks reset button")
    public void userClicksResetButton() {
    }


    @Then("verify that user cannot login with blank credentials and can see please fill out message in username")
    public void verifyThatUserCannotLoginWithBlankCredentialsAndCanSeePleaseFillOutMessageInUsername() {
        boolean r1=Driver.getDriver().getTitle().equals("Symund - QA");
        boolean r2=loginPage.username.getAttribute("required").equals("true");
        boolean r=r1 && r2;
        Assert.assertTrue(r);
        String message = loginPage.username.getAttribute("validationMessage");
        System.out.println(message);
    }

    @Then("verify that user cannot login with blank credentials and can see please fill out message in password;")
    public void verifyThatUserCannotLoginWithBlankCredentialsAndCanSeePleaseFillOutMessageInPassword() {
        boolean r1=Driver.getDriver().getTitle().equals("Symund - QA");
        boolean r2=loginPage.password.getAttribute("required").equals("true");
        boolean r=r1 && r2;
        Assert.assertTrue(r);
    }
}
