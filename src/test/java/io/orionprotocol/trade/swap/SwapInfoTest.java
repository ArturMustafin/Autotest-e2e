package io.orionprotocol.trade.swap;

import io.orionprotocol.BaseTest;
import io.orionprotocol.Environment;
import io.orionprotocol.pages.trade.page.SwapPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;


@Epic(value = "Тесты UI: trade.orionprotocol.io")
@DisplayName("Тесты Welcome to Orion Terminal!")
public class SwapInfoTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Learn How to Trade on Orion Terminal"})
    @DisplayName("Переход на страницу YouTube")
    void goToYouTubeTest(String textHowToTrade) {
        open(Environment.URL_SWAP, SwapPage.class)
                .clickLearnHowToTrade(textHowToTrade)
                .checkNameVideo(textHowToTrade)
                .checkUrlPage();
    }

    @Test
    @DisplayName("Переход в Add Wallet(popup) через кнопку Add Your Wallet")
    void addWalletAndClosePopupTest() {
        open(Environment.URL_SWAP, SwapPage.class)
                .clickTextAddYourWallet()
                .getTradeHeaderBlock()
                .checkTextAddWalletPopup()
                .closeAddWalletPopup()
                .clickAddWalletButton();
    }
}