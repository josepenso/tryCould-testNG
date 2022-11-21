package com.trycloud.stepDef;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class US_14_Steps {

    LoginPage loginRunner= new LoginPage();
    String folderName="Test";

    @When("the user clicks the magnifier icon on the right top")
    public void the_user_clicks_the_magnifier_icon_on_the_right_top() {
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(loginRunner.magnifyIcon).pause(3).click().perform();
        BrowserUtils.waitUntilVisible(loginRunner.searchInput,20);


    }
    @When("users search any existing file,folder,username")
    public void users_search_any_existing_file_folder_user_name() {
        loginRunner.searchInput.sendKeys(folderName);
        BrowserUtils.sleep(2);
        BrowserUtils.waitUntilVisible(loginRunner.confirmFolder(folderName),20);

    }
    @Then("verify the app displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option() {

        BrowserUtils.waitUntilVisible(loginRunner.confirmFolder(folderName),20);
        Assert.assertTrue(loginRunner.confirmFolder(folderName).isDisplayed());


    }




}
