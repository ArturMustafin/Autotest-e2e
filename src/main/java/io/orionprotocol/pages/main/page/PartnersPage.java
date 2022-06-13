package io.orionprotocol.pages.main.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PartnersPage {

    public void checkPartnerSiteOpening(){
        $(By.xpath("//h1[text()='Building the future of DeFi, together.']")).shouldBe(visible);
    }

}