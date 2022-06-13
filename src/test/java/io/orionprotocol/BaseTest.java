package io.orionprotocol;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Driver.initDriver();

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability( "enableVNC",  true);
//        capabilities.setCapability( "enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void tearDown() {
        Driver.clearCookies();
        WebDriverRunner.getWebDriver().close();
    }
}
