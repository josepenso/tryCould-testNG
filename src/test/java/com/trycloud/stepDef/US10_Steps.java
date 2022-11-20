package com.trycloud.stepDef;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class US10_Steps {

    FilesPage filesRunner= new FilesPage();




    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {

        filesRunner.settingBtn.click();
        BrowserUtils.sleep(4);

    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        for (WebElement checkBox :filesRunner.settingOptions) {
            BrowserUtils.highlight(checkBox);
            checkBox.click();
            BrowserUtils.waitFor(1);
            Assert.assertTrue(checkBox.isEnabled());
            checkBox.click();
        }

    }




    String beforeStorage, afterStorage;
    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        beforeStorage = filesRunner.storageAmount.getText();
        System.out.println("beforeStorage = " + beforeStorage);


    }

    @When("user  uploads file with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() {


    }
    @When("user refresh the page")
    public void user_refresh_the_page() {



    }
    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {



    }

}
