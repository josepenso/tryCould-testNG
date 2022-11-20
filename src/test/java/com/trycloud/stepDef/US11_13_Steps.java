package com.trycloud.stepDef;

import com.trycloud.pages.ContactPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.TalkPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class US11_13_Steps {

    LoginPage loginRunner= new LoginPage();
    TalkPage  talkRunner= new TalkPage();
    ContactPage contactRunner= new ContactPage();

    @Given("user on the dashboard page with these {string} and {string}")
    public void user_on_the_dashboard_page(String username, String password) {
        loginRunner.navigateTo();
        loginRunner.trycloud_login(username,password);
        loginRunner.loginButton.click();
        BrowserUtils.waitUntilVisible(loginRunner.customizeBtn,20);

    }



    @When("user search user from the search box")
    public void user_search_user_from_the_search_box() {

        BrowserUtils.sleep(4);
        talkRunner.userSearchField.sendKeys(Config.getProperty("userSearch"));
        talkRunner.getUserChat(Config.getProperty("userSearch")).click();
        talkRunner.toggleBtn.click();
        BrowserUtils.sleep(4);




    }
    @When("user write a message")
    public void user_write_a_message() {


        talkRunner.convInput.sendKeys(Config.getProperty("randomMsg"));

    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {

        talkRunner.summitBtn.click();
        BrowserUtils.sleep(4);


    }
    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log() {

        Assert.assertTrue(talkRunner.confirmChat(Config.getProperty("randomMsg")).isDisplayed());



    }

    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {

        contactRunner.select_contact_option();
        BrowserUtils.waitUntilVisible(contactRunner.showAllContactsBtn,20);

        for (WebElement each: contactRunner.contactList){
            Assert.assertTrue(each.isDisplayed());
        }


    }



}
