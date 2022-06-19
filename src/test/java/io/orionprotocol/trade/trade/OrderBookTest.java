package io.orionprotocol.trade.trade;

import io.orionprotocol.BaseTest;
import io.orionprotocol.Environment;
import io.orionprotocol.pages.trade.page.TradePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


@Epic(value = "Тесты UI: trade.orionprotocol.io")
@Feature(value = "Trade")
@DisplayName("Тесты OrderBook")
public class OrderBookTest extends BaseTest {

    @Test
    @DisplayName("Проверка содержимого OrderBook = !0")
    void checkListInOrderBookTest() {
        open(Environment.URL_TRADE, TradePage.class)
                .checkOrderBooksNoNull();
    }

    @Disabled("БАГ есть в списке div без класса ")
    @Test
    @DisplayName("Отображение иконок токена в списке OrderBook")
    void openDiagramTest() {
        open(Environment.URL_TRADE, TradePage.class)
                .clickVirtualPath()
                .checkImgInOrderBooks();
    }


}