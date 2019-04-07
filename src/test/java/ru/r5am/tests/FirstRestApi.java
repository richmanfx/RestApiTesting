package ru.r5am.tests;


import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;


public class FirstRestApi extends BaseTest{

    @Test
    public void returnCode200() {

        when().
                get(restApiConfig.testingHost() + ":" + restApiConfig.testingPort()).
        then().
                statusCode(200);
        log.debug("Тест прошёл");
        allureLog("Тест прошёл");

    }


}
