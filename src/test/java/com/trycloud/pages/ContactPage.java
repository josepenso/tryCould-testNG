package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactPage {

    public ContactPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//header//div[@id='contactsmenu']")
    public WebElement contactOption;

    @FindAll(@FindBy(xpath = "//div[@id='contactsmenu-menu']//div[@class='full-name']"))
    public List<WebElement> contactList;

    @FindBy(xpath = "//div[@id='contactsmenu-menu']//div//a[contains(text(),'Show all')]")
    public WebElement showAllContactsBtn;


    public void select_contact_option(){
        Actions actions= new Actions(Driver.getDriver());

        actions.moveToElement(contactOption).pause(2).click().perform();

    }








}
