package com.tasks.step_definitions;


import com.tasks.pages.HomePage;
import com.tasks.pages.SolutionsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class SolutionsStepDefs {

    SolutionsPage solutionsPage = new SolutionsPage();

    public static void main(String[] args) throws IOException {
        HomePage homePage = new HomePage();
        SolutionsPage solutionsPage = new SolutionsPage();
        homePage.setUp();
        solutionsPage.clickViewAll();
        //    Assert.assertEquals("Fire investigation - Davies",solutionsPage.sendKey());
        //    solutionsPage.capture();
    }

    @When("I click the {string} module")
    public void i_click_the_module(String module) {
        solutionsPage.navigateToModule(module).click();
    }

    @Then("I scroll down and click on {string} button")
    public void i_scroll_down_and_click_on_button(String subModule) {
        solutionsPage.clickViewAll();
    }
    @Then("I search the {string} and click on it")
    public void i_search_the_and_click_on_it(String searchText) {
        solutionsPage.sendKey();
    }
    @Then("I verify that it's navigated to {string} page")
    public void iVerifyThatItSNavigatedToPage(String expectedPageTitle) {
        String actualPageTitle = solutionsPage.getPageTitle();
        Assert.assertEquals("verify that navigate to right page",expectedPageTitle,actualPageTitle);
    }
    @Then("I capture results section on Fire investigation case study")
    public void i_capture_results_section_on_fire_investigation_case_study() throws IOException {
        solutionsPage.captureResult();
    }


}
