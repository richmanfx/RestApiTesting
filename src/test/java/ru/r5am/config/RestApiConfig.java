package ru.r5am.config;


import org.aeonbits.owner.Config;


@Config.Sources({ "file:RestApi.config" })
public interface RestApiConfig extends Config {

    String testingHost();

    int testingPort();

    String basePath();

    String testDataDir();

    String dataFileName();

}
