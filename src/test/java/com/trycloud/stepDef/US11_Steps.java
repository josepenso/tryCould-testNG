package com.trycloud.stepDef;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.TalkPage;
import com.trycloud.utils.BrowserUtils;
import com.trycloud.utils.Config;
import com.trycloud.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US11_Steps {

    LoginPage loginRunner= new LoginPage();
    TalkPage  talkRunner= new TalkPage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        loginRunner.login_with_valid_credentials();
        BrowserUtils.waitUntilVisible(loginRunner.customizeBtn,20);

    }



    @When("user search user from the search box")
    public void user_search_user_from_the_search_box() {

        BrowserUtils.sleep(3);
        talkRunner.userSearchField.sendKeys(Config.getProperty("userSearch"));
        talkRunner.getUserChat(Config.getProperty("userSearch")).click();
        talkRunner.toggleBtn.click();
        BrowserUtils.sleep(3);




    }
    @When("user write a message")
    public void user_write_a_message() {


        talkRunner.convInput.sendKeys(Config.getProperty("randomMsg"));


    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {

        talkRunner.summitBtn.click();
        BrowserUtils.sleep(2);



    }
    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log() {

        talkRunner.confirmChat(Config.getProperty("randomMsg")).isDisplayed();



    }

}
