package io.orionprotocol;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {

    @BeforeAll
    static void setUp() {
        Driver.initDriver();
    }

    @AfterEach
    void tearDown() {
        Driver.clearCookies();
        WebDriverRunner.getWebDriver().close();
    }
}