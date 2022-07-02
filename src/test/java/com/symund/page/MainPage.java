package com.symund.page;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "expand")
    public WebElement userBtn;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutBtn;






}
