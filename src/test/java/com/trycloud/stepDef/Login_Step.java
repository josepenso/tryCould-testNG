package com.trycloud.stepDef;

import com.trycloud.pages.LoginPage;
import com.trycloud.utils.Config;
import com.trycloud.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;


public class Login_Step {

    LoginPage cloudDriver= new LoginPage();
    @Given("user on the login page")
    public void user_on_the_login() {

        cloudDriver.navigateTo();
    }
    @When("user types username {string} and password {string}")
    public void user_use_username_and_passcode(String username,String password) {

        cloudDriver.trycloud_login(username,password);


    }
    @When("user click the login button")
    public void user_click_the_login_button() {


        cloudDriver.user_click_loginBtn();

        BrowserUtils.waitUntilVisible(cloudDriver.customizeBtn,20);


    }
    @Then("verify the user should be at the dashboard {string} page")
    public void verify_the_user_should_be_at_the_dashboard_page(String title) {
        BrowserUtils.verifyTitleEquals(title);
    }

    @When("user enter invalid username {string} and  password {string}")
    public void user_enter_invalid_username_and_password(String username, String password) {
       cloudDriver.trycloud_login(username,password);
    }

    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String msg) {

        cloudDriver.wrong_msg_is_displayed(msg);

    }

    @When("user click the login Button")
    public void user_click_the_login_buttonNega() {


        cloudDriver.user_click_loginBtn();

    }

    @When("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        cloudDriver.trycloud_login(Config.getProperty("username"),Config.getProperty("password"));
        cloudDriver.user_click_loginBtn();
    }



    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> modules) {

        cloudDriver.user_verify_modules(modules);



    }










}
