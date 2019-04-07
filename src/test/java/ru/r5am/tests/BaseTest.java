package ru.r5am.tests;


import io.qameta.allure.Step;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Logger;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;

import org.testng.annotations.BeforeSuite;
import ru.r5am.config.RestApiConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.readString;


public class BaseTest {

    static final Logger log = LogManager.getLogger();
    static RestApiConfig restApiConfig = ConfigFactory.create(RestApiConfig.class);


    /**
     * Message output in Allure-report
     *
     * @param message Message text
     */
    @Attachment("Сообщение: {message}")
    protected String allureMessage(String message) {
        return message;
    }


    /**
     * Message output in Allure-report via @Step annotation
     *
     * @param message Message text
     */
    @Step("{message}")
    protected void allureLog(String message) {
        // The message " msg " is displayed in the Allure-report via @Step annotation
    }


    /**
     * Read test data from file
     */
    @BeforeSuite
    void readApiTestData() throws IOException {

        String jsonDataFromFile =
                readString(Paths.get(restApiConfig.testDataDir() + "/" + restApiConfig.dataFileName()));

        log.info("Test data from file: \n{}", jsonDataFromFile);
    }

}
