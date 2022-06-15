package io.orionprotocol;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    @BeforeEach
    void setUp() {

        Driver.initDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    }

    @AfterEach
    void tearDown() {
        Driver.clearCookies();
        WebDriverRunner.getWebDriver().close();
    }
}
