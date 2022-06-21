package io.orionprotocol.trade.trade;

import io.orionprotocol.BaseTest;
import io.orionprotocol.Environment;
import io.orionprotocol.pages.trade.page.TradePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;


@Epic(value = "Тесты UI: trade.orionprotocol.io")
@Feature(value = "Trade")
@DisplayName("Тесты контейнера торговых пар")
//@ExtendWith(SelenoidExtension.class)
public class ContainerPairTest extends BaseTest {

    @Test
    @DisplayName("Проверить открытые контейнера торговых пар")
    void openContainersTradingPairsTest() {
        open(Environment.URL_TRADE, TradePage.class)
                .clickContainerPair()
                .checkOpenContainerPair();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "BTC-USDT",
            "ETH-USDT",
            "ORN-USDT"})
    @DisplayName("Проверка поиска токенов")
    void searchTokenTest(String token) {
        open(Environment.URL_TRADE, TradePage.class)
                .clickContainerPair()
                .inputToken(token)
                .checkFoundToken(token);
    }



    //todo        "Change" N/A серый  под элемент
    @ParameterizedTest
    @ValueSource(strings = {
            "Pair"})
    @DisplayName("Проверка сортировки")
    void sortingCheckPairTest(String tableHead) {
        open(Environment.URL_TRADE, TradePage.class)
                .clickContainerPair()
                .clickTableHead(tableHead)
                .checkSort(tableHead);
    }


}