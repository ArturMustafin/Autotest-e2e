package io.orionprotocol.pages.main.blocks;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FooterBlock {

    public void clickLogo(){
        $(By.className("footer-logo")).click();
    }
}
