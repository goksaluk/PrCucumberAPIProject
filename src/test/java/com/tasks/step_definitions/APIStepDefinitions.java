package com.tasks.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APIStepDefinitions {

    private Response response;
    private ContentType contentType;

    Faker f = new Faker();

    @When("the user is on Placeholder page")
    public void the_user_is_on_Placeholder_page() {
        baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("the user accepts content type as {string}")
    public void the_user_accepts_content_type_as(String string) {
        if (string.toLowerCase().contains("json")) {
            contentType = ContentType.JSON;
        } else if (string.toLowerCase().contains("xml")) {
            contentType = ContentType.XML;
        }
    }


    @When("path parameter should be {string}, random id: {string} and send request to {string}")
    public void path_parameter_should_be_random_id_and_send_request_to(String key, String value, String path) {
        response = given().contentType(contentType).
                           pathParam(key,value).
                    and(). get(path);
    }


    @When("the user prints out their email adress to the console")
    public void the_user_prints_out_their_email_adress_to_the_console() {
        int num=f.number().numberBetween(1,5);
        List<Map<String, Integer>> resp = response.jsonPath().getList("");
        for (Map record : resp) {
            if (record.get("id").equals(num)) {
                System.out.println(record.get("email"));
            }
        }
    }

    @Then("the user gets this user's associated posts")
    public void the_user_gets_this_user_s_associated_posts() {
        int num=f.number().numberBetween(1,5);
        response = given().contentType(ContentType.JSON).
                           queryParam("userId", num).
                   and().  get("posts");

    }

    @Then("verify that they contains a valid post IDs an integer between one and hundred")
    public void verify_that_they_contains_a_valid_post_IDs_an_integer_between_one_and_hundred() {
        List<Integer> list = response.jsonPath().getList("id");
        for (int each : list) {
            Assert.assertTrue(each >= 0 && each < 100);
        }
    }

    @When("the user sends POST request to {string} with following information:")
    public void the_user_sends_POST_request_to_with_following_information(String path, List<Map<String, String>> newRecord) {
        for( Map<String, String> map : newRecord) {
            response = given().
                             accept(contentType).
                             queryParams(map).
                       when().
                             post(path);
            response.then().log().body(true);
        }
    }

    @Then("verify that status code shouldn't be {int}")
    public void verify_that_status_code_shouldn_t_be(Integer int1) {
         response.then().assertThat().statusCode(is(not(200)));
    }


}
