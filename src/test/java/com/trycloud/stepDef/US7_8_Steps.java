package com.trycloud.stepDef;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US7_8_Steps {

    FilesPage filesRunner= new FilesPage();

    @When("user click \"new folder”")
    public void user_click_new_folder() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user write a folder name")
    public void user_write_a_folder_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user uploads a file with the upload file option")
    public void the_user_uploads_a_file_with_the_upload_file_option() {


    }
    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {



    }






    @When("the user clicks the {string} sub-module on the left side")
    public void the_user_clicks_the_sub_module_on_the_left_side(String option) {

        BrowserUtils.sleep(5);
        filesRunner.deletedFiles.click();

    }
    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page() {


    }



}
