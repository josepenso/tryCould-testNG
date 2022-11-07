package com.trycloud.utils;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class Utils {
    //Methods are static. Because we do not want to create an object to call those methods.
    // We just want to call those methods with class name. That is why they are static type


    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3);
     *
     * @param seconds
     */
    public static void sleep(int seconds) {
        // 1 second = 1000 millis
        // millis = seconds*1000
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }



    public static void verifyTitleEquals(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }
    public static void verifyTitleContains(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }



    public static void doubleClick(WebElement element) {
        Actions action = new Actions(Driver.getDriver());
        action.doubleClick(element).perform();
    }


    public static List<String> dropdown_options_toString(WebElement options) {

        Select select = new Select(options);
        List<WebElement> actualOptions = select.getOptions();
        List<String> actualOptionStr = new ArrayList<>();

        for (WebElement each : actualOptions) {
            actualOptionStr.add(each.getText());
        }

        return actualOptionStr;

    }

    public static void waitUntilNotVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitUntilVisible(WebElement element,int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilClickable(WebElement element,int seconds){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
}