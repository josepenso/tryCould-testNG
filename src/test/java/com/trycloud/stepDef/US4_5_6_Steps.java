package com.trycloud.stepDef;

import com.trycloud.pages.FilesPage;

import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class US4_5_6_Steps {



    FilesPage filesRunner= new FilesPage();

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {


        BrowserUtils.waitUntilVisible(filesRunner.allBoxesBtn,20);
        filesRunner.allBoxesBtn.click();


    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        for (WebElement each:filesRunner.AllCheckBoxes){

            Assert.assertTrue(each.isDisplayed());

        }

    }



    @When("the user clicks action-icon from any file on the page and choose the {string} option")
    public void the_user_clicks_action_icon_from_any_file_on_the_page_and_choose_the_option(String option) {

        BrowserUtils.sleep(2);
        filesRunner.selectAllFiles(option);

    }


    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String option) {

       if (filesRunner.toggleBtn.isDisplayed()){
           filesRunner.toggleBtn.click();
           filesRunner.clickFavorites();
       }
        filesRunner.clickFavorites();



    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {

        filesRunner.verifyFavFiles();




    }



    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {

        filesRunner.clickFavorites();
        Assert.assertTrue(filesRunner.noFavoritesYetStar.isDisplayed());
    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filesRunner.uploadBtnClick();

    }
    @When("users uploads file with the {string} option")
    public void users_uploads_file_with_the_upload_file_option(String option) {
        filesRunner.uploadCommand(option);


    }
    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        filesRunner.verifyFileUpload();
        for (int i=0;i<filesRunner.fileNames.size();i++){
            if (filesRunner.fileNames.get(i).getText().contains(filesRunner.uploadFileName)){

            }
        }
    }
}
