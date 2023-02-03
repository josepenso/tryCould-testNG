package com.trycloud.stepDef;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class US9_Steps {

     LoginPage loginRunner= new LoginPage();
     FilesPage filesRunner = new FilesPage();


    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String module) {

        loginRunner.click_on_module_option(module);

    }

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String title) {

        BrowserUtils.verifyTitleContains(title);


    }
    @When("user click {string}-icon  from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page(String option) {


      // BrowserUtils.waitUntilVisible(filesRunner.tBodyElement,20);
        BrowserUtils.sleep(2);
        filesRunner.select_option(option);

    }
    @When("user choose the {string} option")
    public void user_choose_the_option(String option) {



            BrowserUtils.sleep(5);
            filesRunner.select_option(option);
            BrowserUtils.sleep(2);



    }
    @When("user write a {string} inside the input box")
    public void user_write_a_comment_inside_the_input_box(String comment) {


        filesRunner.findDetailsOptions(comment).click();
       filesRunner.inputMsg.sendKeys(Config.getProperty("randomMsg"));

    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {

        filesRunner.submitBtnDetailsOption.click();

    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {

        BrowserUtils.sleep(1);
        Assert.assertTrue(filesRunner.confirmChat(Config.getProperty("randomMsg")).isDisplayed());


    }


}
