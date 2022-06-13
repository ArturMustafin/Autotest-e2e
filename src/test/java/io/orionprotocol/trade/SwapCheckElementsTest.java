package io.orionprotocol.trade;


import io.orionprotocol.AppConfigTesting;
import io.orionprotocol.BaseTest;
import io.orionprotocol.pages.trade.page.SwapPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;


@Epic(value = "Тесты UI: trade.orionprotocol.io")
@DisplayName("Тесты страницы Swap на видимость элементов")
//@ExtendWith(ConfigExtension.class)
public class SwapCheckElementsTest extends BaseTest {

    @ParameterizedTest(name = "Перейти на страницу - {0}")
    @MethodSource("dataListForMenu")
    @DisplayName("Проверка левого меню")
    void checkLeftMenuTest(String endPoint, String url) {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .getLeftNavigation()
                .goToPage(endPoint)
                .checkUrlPage(url);
    }

    private static Stream<Arguments> dataListForMenu() {
        return Stream.of(
                Arguments.of("/swap", AppConfigTesting.URL_SWAP),
                Arguments.of("/trade", AppConfigTesting.URL_TRADE),
                Arguments.of("/dashboard/bridge", AppConfigTesting.URL_BRIDGE),
                Arguments.of("/governance", AppConfigTesting.URL_GOVERNANCE),
                Arguments.of("/pools/farming", AppConfigTesting.URL_POOLS),
                Arguments.of("/ido", AppConfigTesting.URL_IDO),
                Arguments.of("/stats", AppConfigTesting.URL_STATS),
                Arguments.of("/fiat", AppConfigTesting.URL_FIAT)
        );
    }

    @Test
    @DisplayName("Тест открытия popup кошелька  из 'Add wallet' button")
    void openingPopupWalletFromAddWalletButtonTest() {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .clickAddWalletButton()
                .checkTextAddWalletPopup();
    }

    @Test
    @DisplayName("Тест ввода чисел в From и вывод ответа в To")
    void checkInputFieldTestFromTest() {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .enterRandomNumbersInFieldFrom()
                .checkInputFieldTo();
    }

    @Test
    @DisplayName("Тест ввода чисел в To и вывод ответа в From")
    void checkInputFieldTestToTest() {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .enterRandomNumbersInFieldTo()
                .checkInputFieldFrom();
    }

    @ParameterizedTest(name = "Период - {0}")
    @ValueSource(strings = {"1D", "1W", "1M", "1Y"})
    @DisplayName("Выбрать отчетный период для графика")
    void checkTimePeriodButtonsTest(String reportingPeriod) {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .clickGotItButton()
                .checkTimePeriodButtons(reportingPeriod);
    }

    @Test
    @DisplayName("Тест открытия графика canvas")
    void openDiagramTest() {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .clickGotItButton()
                .checkDiagram();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Learn How to Trade on Orion Terminal"})
    @DisplayName("Переход на страницу YouTube")
    void goToYouTubeTest(String textHowToTrade) {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .clickLearnHowToTrade(textHowToTrade)
                .checkNameVideo(textHowToTrade)
                .checkUrlPage();
    }

    @Test
    @DisplayName("Переход в Add Wallet(popup) через кнопку Add Wallet")
    void addWalletAndClosePopupTest() {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .clickTextAddWallet()
                .checkTextAddWalletPopup()
                .closeAddWalletPopup()
                .clickAddWalletButton();
    }

    @Test
    @DisplayName("Переход в Add Wallet(popup) через хедер ConnectWallet")
    void popupWalletWithConnectWalletTest() {
        open(AppConfigTesting.URL_SWAP, SwapPage.class)
                .getTradeHeaderBlock()
                .clickTextConnectWallet()
                .checkTextAddWalletPopup();
    }

    //Todo swap  подсказка комиссии(How to reduce fee?)
    //Todo swap  смена токенов -> <-
    //Todo: сделать проверки внутри addWallet Popup
    //Todo swap history (много элементов)

}
