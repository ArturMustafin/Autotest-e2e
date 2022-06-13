package io.orionprotocol.pages.trade.blocks;


import io.orionprotocol.pages.trade.page.SwapPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class TradeHeaderBlock {

    @Step("Нажать на текст: Connect Wallet")
    public SwapPage  clickTextConnectWallet(){
        $x("//div[text()='Connect Wallet']").click();
        return page(SwapPage.class);
    }

}
