package com.cydeo.page;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "expand")
    public WebElement userBtn;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutBtn;






}
