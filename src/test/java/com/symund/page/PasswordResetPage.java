package com.symund.page;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {
    public PasswordResetPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user")
    public WebElement userInput;


    @FindBy(id = "reset-password-submit")
    public WebElement resetPasswordBtn;

}
