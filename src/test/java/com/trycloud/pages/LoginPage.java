package com.trycloud.pages;

import com.trycloud.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user']")
    private WebElement usernameBox;


    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@id='lost-password']")
    private WebElement lostPasswordBtn;


    









}
