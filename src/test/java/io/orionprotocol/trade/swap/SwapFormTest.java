package io.orionprotocol.trade.swap;


import io.orionprotocol.BaseTest;
import io.orionprotocol.Environment;
import io.orionprotocol.pages.trade.page.SwapPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


@Epic(value = "Тесты UI: trade.orionprotocol.io")
@DisplayName("Тесты формы Swap")
//@ExtendWith(ConfigExtension.class)
public class SwapFormTest extends BaseTest {

    @Test
    @DisplayName("Тест открытия popup кошелька  из 'Add wallet' button")
    void openingPopupWalletFromAddWalletButtonTest() {
        open(Environment.URL_SWAP, SwapPage.class)
                .clickAddWalletButton()
                .getTradeHeaderBlock()
                .checkTextAddWalletPopup();
    }

    @Test
    @DisplayName("Тест ввода чисел в From и вывод ответа в To")
    void checkInputFieldTestFromTest() {
        open(Environment.URL_SWAP, SwapPage.class)
                .enterRandomNumbersInFieldFrom()
                .checkInputFieldTo();
    }

    @Test
    @DisplayName("Тест ввода чисел в To и вывод ответа в From")
    void checkInputFieldTestToTest() {
        open(Environment.URL_SWAP, SwapPage.class)
                .enterRandomNumbersInFieldTo()
                .checkInputFieldFrom();
    }

    @Test
    @DisplayName("Переход в How to reduce fee(popup)")
    void feeOpenAndClosePopupTest() {
        open(Environment.URL_SWAP, SwapPage.class)
                .clickHowToReduceFee()
                .checkTextPayLessFeePopup()
                .closeFeePopup();
    }

    //Todo Переход в Add Wallet(popup) через How to reduce fee
    //Todo swap  смена токенов -> <-
    //Todo: сделать проверки внутри addWallet Popup
    //Todo swap history (много элементов)
}
