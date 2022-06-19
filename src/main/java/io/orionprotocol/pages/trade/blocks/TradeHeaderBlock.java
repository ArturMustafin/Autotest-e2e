package io.orionprotocol.pages.trade.blocks;


import io.orionprotocol.pages.trade.page.SwapPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class TradeHeaderBlock {

    @Step("Нажать на текст: Connect Wallet")
    public TradeHeaderBlock clickTextConnectWallet() {
        $x("//div[text()='Connect Wallet']").click();
        return this;
    }

    //============================================== Add Wallet (popup) ================================================
    @Step("Проверить popup на текст: Add Wallet")
    public TradeHeaderBlock checkTextAddWalletPopup() {
        $x("//div[@class='Popup_root__2Q_OX']//div[text()='Add Wallet']")
                .shouldBe(visible)
                .shouldHave(text("Add Wallet"));
        return this;
    }

    @Step("Нажать закрыть: Add Wallet(popup)")
    public SwapPage closeAddWalletPopup() {
        $x("//div[@class='Popup_root__2Q_OX']//div[@class='Icon_root__1SgNj Icon_theme__2vDcE']")
                .click();
        return page(SwapPage.class);
    }
}
