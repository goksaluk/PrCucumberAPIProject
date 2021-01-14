package com.tasks.step_definitions;

import org.junit.Assert;
import org.junit.Before;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class APITests {

    @Before
    public void setUp(){

        baseURI= "https://5f99522350d84900163b8737.mockapi.io/";
    }

    @Test
    public void test(){
        Response response = given().get("tech-test/articles");

        List<Map<String, Object>> resp = response.jsonPath().getList("");

        System.out.println(resp);











//        Response response = given(). contentType(ContentType.JSON).
//                get("users");
//       // String str = response.jsonPath().get("username[8]");
//       // System.out.println(str);
//
//       List<String> list =response.jsonPath().getList("username");
//
//        for (String user : list){
//            if (user.equals("Delphine")){
//                System.out.println(user);
//            }
//        }

//        Faker f =new Faker();
//        int num = f.number().numberBetween(1,5);
//
//        //2.1- Get a random user (userID), print out its email address to console.
//        Response response = given(). contentType(ContentType.JSON).
//                pathParam("postId","1").
//                get("posts/{postId}/comments");
//
//        List<Map<String, Integer>> resp = response.jsonPath().getList("");
//
//        for (Map record : resp){
//            if(record.get("id").equals("num")){
//                System.out.println(record.get("email"));
//            }
//        }
//
//
//        //2.2- Using this userID, get this user’s associated posts and
//        // verify they contains a valid Post IDs (an Integer between 1 and 100).
//        response = given().contentType(ContentType.JSON).
//                           queryParam("userId",num).
//                           get("posts");
//
//        List<Integer> list = response.jsonPath().getList("id");
//
//        for (int each : list){
//            Assert.assertTrue(each>=0 && each<100);
//        }
//
//
//        //2.3- Do a post using same userID with a non-empty title and body,
//        // verify the correct response is returned (since this is a mock API,
//        // it might not return Response code 200, so check the documentation).
//        Map<String ,String> newRecord = new HashMap<>();
//        newRecord.put("title", "foo");
//        newRecord.put("body", "bar");
//        newRecord.put("userId", "1");
//
//        given().contentType("application/json").
//                body(newRecord).
//        when().
//                post("posts").
//        then().
//                assertThat().statusCode(201).
//                log().all();
//
//
//

   }




}

