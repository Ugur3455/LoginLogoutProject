package com.symund.step_definitions;

import com.symund.page.LoginPage;
import com.symund.page.MainPage;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutFunc_StepDefinitions {

    LoginPage login = new LoginPage();
    MainPage main = new MainPage();
    String expectedTitle ="Symund - QA";


    @Given("Users logged in page with valid credentials")
    public void users_logged_in_page_with_valid_credentials() {
        Driver.getDriver().get("https://qa.symund.com/");
        login.username.sendKeys("Employee71");
        login.password.sendKeys("Employee123");
        login.loginBtn.click();
    }
    @When("users click on user's profile button")
    public void users_click_on_user_s_profile_button() {
        main.userBtn.click();
    }
    @When("users click on logout button")
    public void users_click_on_logout_button() {
        main.logoutBtn.click();

    }
    @Then("verify that users can log out")
    public void verify_that_users_can_log_out() {
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    @Then("verify that users can not login with clicking step back")
    public void verify_that_users_can_not_login_with_clicking_step_back() {
        Driver.getDriver().navigate().back();
    }


    @Then("verify that users shouldn't be able to login")
    public void verifyThatUsersShouldnTBeAbleToLogin() {
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }
}
