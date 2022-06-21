package io.orionprotocol;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


//TODO: до делать
public class Driver {
    public static void initDriver() {

        Configuration.remote = "http://192.168.0.154:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder = "target/downloads";

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", false);
        options.put("enableLog", false);

        Configuration.browserCapabilities = new ChromeOptions();
        Configuration.browserCapabilities.setCapability("selenoid:options", options);

//        DesiredCapabilities browser = new DesiredCapabilities();
//        browser.setBrowserName("chrome");
//        browser.setCapability("enableVNC", true);
//        setWebDriver(new RemoteWebDriver(URI.create("http://192.168.0.154:4444/wd/hub").toURL(),browser));

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    public static void clearCookies() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        WebDriverRunner.clearBrowserCache();
    }
}
