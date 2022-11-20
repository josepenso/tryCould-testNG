package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalkPage {
    public TalkPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@placeholder='Search conversations or users']")
    public WebElement userSearchField;

    @FindBy(xpath = "//div[@class='new-message-form__input']//div[@placeholder='Write message, @ to mention someone …']")
    public WebElement convInput;

    @FindBy(xpath = "//button[@aria-label='Send message']")
    public WebElement summitBtn;


    @FindBy(xpath = "//a[@class='app-navigation-toggle']")
    public WebElement toggleBtn;



    public WebElement getUserChat(String user){
        String xPath="//a//span[contains(text(),'"+user+"')]";
        return  Driver.getDriver().findElement(By.xpath(xPath));
    }

    public WebElement confirmChat(String text ){
        String xPath="//div[@class='message-group']//div[contains(text(),'"+text+"')]";
        return Driver.getDriver().findElement(By.xpath(xPath));
    }







}
