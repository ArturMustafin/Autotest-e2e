package io.orionprotocol.pages.main.page;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AboutPage {

    @Step("Перейти на страницу {0}")
    public String goToPage() {
        return $x("//h1[contains(., 'ABOUT')]").getText();
    }
}