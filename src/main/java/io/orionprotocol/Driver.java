package io.orionprotocol;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Configuration.headless;

//TODO: до делать
public class Driver {
    public static void initDriver() {

        // Get settings from command line
        TestConfig.initConfig();

        // Set settings for selenide browser

//        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = false;
//        Configuration.screenshots = false;
//        Configuration.timeout = 6000;

//        Configuration.browser = Browsers.FIREFOX;

//        if(TestConfig.isHeadless()) {
//            Configuration.headless = true;
//        } else {
//            Configuration.headless = false;
//        }

        switch (TestConfig.browser) {
            case "safari":
                Configuration.browser = Browsers.SAFARI;
                break;
            case "firefox":
                Configuration.browser = Browsers.FIREFOX;
                break;
            default:
                Configuration.browser = Browsers.CHROME;
                break;
        }

    }

    public static void clearCookies() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        WebDriverRunner.clearBrowserCache();
    }
}
