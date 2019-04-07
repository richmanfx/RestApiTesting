package ru.r5am.tests;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class FirstRestApi extends BaseTest{

    @Test
    public void returnCode200() {

        RequestSpecification requestSpec = new RequestSpecBuilder().
                setBaseUri(restApiConfig.testingHost()).
                setPort(restApiConfig.testingPort()).
//                setAccept(ContentType.JSON).
                build();

        given().spec(requestSpec).
            when().
                get("/").
            then().
                statusCode(200);
//                body("[0].EndPoint", Matchers.equalTo("/v1/endpoint1"));

        log.debug("Тест прошёл");
        allureLog("Тест прошёл");

    }


}
