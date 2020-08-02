package com.tasks.step_definitions;

import com.tasks.pages.GooglePage;
import com.tasks.utilities.ConfigurationReader;
import com.tasks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class GoogleStepDefinitions {

    GooglePage googlePage = new GooglePage();

    @Given("the user is on the Google")
    public void the_user_is_on_the_Google() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user search {string}")
    public void the_user_search(String Element) {
        googlePage.searchElement(Element);
    }

    @Then("displayed the result")
    public void displayed_the_result() {
        Assert.assertTrue(googlePage.results.isDisplayed());
        System.out.println("googlePage.results.getText() = " + googlePage.results.getText());
        System.out.println("googlePage.getResultOfSeaarch() = " + googlePage.getResultOfSeaarch());
    }


    @And("verify the available {string} Links number")
    public void verifyTheAvailableLinksNumber(String link) {
        System.out.println("number of gumtree links = " + googlePage.getGumtreeLinks(link).size());
    }

    List<String> titleOfGumtreeLinks = new ArrayList<>();
    List<Integer> numOfGumtreeCars  = new ArrayList<>();
    @Then("navigate to each Gumtree Link")
    public void navigate_to_each_Gumtree_Link() throws InterruptedException {

        for(WebElement gumtreeLink : googlePage.gumtreeLinks){
            gumtreeLink.click();
            googlePage.acceptBtn.click();
            googlePage.waitForVisibility(googlePage.numberOfCarsGumtree);

            String title = googlePage.getTitle();
            System.out.println("title = " + title);
            titleOfGumtreeLinks.add(title);
            Integer numCarr = googlePage.getNumberOfCars();
            numOfGumtreeCars.add(numCarr);

            Driver.get().navigate().back();
        }
    }

    @Then("verify the title is displayed")
    public void verify_the_title_is_displayed() {
        for (String title : titleOfGumtreeLinks) {
            Assert.assertEquals("Used Cars for Sale in London | Great Local Deals | Gumtree",title);
            System.out.println("title = " + title);
        }
    }

    @Then("verify the number of cars grater the {int}")
    public void verifyTheNumberOfCarsGraterThe(int number)  {

        for (int num : numOfGumtreeCars) {
            Assert.assertTrue(num>number);
        }

    }
}