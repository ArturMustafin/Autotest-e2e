package io.orionprotocol.pages.trade.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


/**
 * Страница "Fiat"
 */
public class FiatPage extends TradeBasePage {

    @Step("Проверить наличие кнопки 'Buy'")
    public void checkBuyButton() {
        $x("//div[@data-testid='fiat']//div[text()='Buy']")
                .shouldBe(visible)
                .shouldHave(text("Buy"));
    }
}