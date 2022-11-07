package com.trycloud.pages;

import com.trycloud.utils.Config;
import com.trycloud.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public  abstract class  BasePage {
    public void navigateTo(){

    }
    public WebElement findModuleElements(String element){
        return Driver.getDriver().findElement(By.xpath(element));
    }

    public void click_on_module_option(String option){
    }
    public WebElement user_choose(String option){

        return Driver.getDriver().findElement(By.xpath(option));
    }

    public WebElement choose_subModuleOption(String option){

        return Driver.getDriver().findElement(By.xpath(option));
    }




}
