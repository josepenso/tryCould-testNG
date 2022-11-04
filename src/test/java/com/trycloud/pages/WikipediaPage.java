package com.trycloud.pages;



import com.trycloud.utils.Config;
import com.trycloud.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WikipediaPage {
    public WikipediaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement wikipeadiaSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchBtn;

    @FindBy(xpath = "//a[.='View history']")
    private WebElement viewHistoryElement;


    public void navigateTo(){
        Driver.getDriver().get(Config.getProperty("wikipediaUrl"));
    }


    public void searching(String searching){
        wikipeadiaSearch.sendKeys(searching);
    }

    public void clicking_searchBtn(){
        searchBtn.click();
    }

    public void title_verification(String expected){
        String actual = Driver.getDriver().getTitle();

        Assert.assertTrue(actual.contains(expected));

    }











}
