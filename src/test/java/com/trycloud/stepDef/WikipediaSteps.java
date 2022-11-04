package com.trycloud.stepDef;



import com.trycloud.pages.WikipediaPage;
import com.trycloud.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WikipediaSteps {


  WikipediaPage wikiRunner= new WikipediaPage();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
     Driver.getDriver().get("https://www.wikipedia.org/");
    }
    @When("User types {string} in the wiki search box")
    public void user_types_subject_in_the_wiki_search_box(String searching) {
    wikiRunner.searching(searching);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
       wikiRunner.clicking_searchBtn();
    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title(String searching) {
      wikiRunner.title_verification(searching);

    }
}
