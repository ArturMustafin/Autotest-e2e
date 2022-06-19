package io.orionprotocol.trade;

import io.orionprotocol.BaseTest;
import io.orionprotocol.Environment;
import io.orionprotocol.pages.trade.page.SwapPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;


@Epic(value = "Тесты UI: trade.orionprotocol.io")
@DisplayName("Тесты LeftMenu и Header элементов")
public class HeaderAndLeftMenuTest extends BaseTest {

    @ParameterizedTest(name = "Перейти на страницу - {0}")
    @MethodSource("dataListForMenu")
    @DisplayName("Проверка левого меню")
    void checkLeftMenuTest(String endPoint, String url) {
        open(Environment.URL_SWAP, SwapPage.class)
                .getLeftNavigation()
                .goToPage(endPoint)
                .checkUrlPage(url);
    }

    @Test
    @DisplayName("Переход в Add Wallet(popup) через хедер ConnectWallet")
    void popupWalletWithConnectWalletTest() {
        open(Environment.URL_SWAP, SwapPage.class)
                .getTradeHeaderBlock()
                .clickTextConnectWallet()
                .checkTextAddWalletPopup();
    }


    private static Stream<Arguments> dataListForMenu() {
        return Stream.of(
                Arguments.of("/swap", Environment.URL_SWAP),
                Arguments.of("/trade", Environment.URL_TRADE),
                Arguments.of("/dashboard/bridge", Environment.URL_DASHBOARD_BRIDGE),
                Arguments.of("/governance", Environment.URL_GOVERNANCE),
                Arguments.of("/pools/farming", Environment.URL_POOLS),
                Arguments.of("/ido", Environment.URL_IDO),
                Arguments.of("/stats", Environment.URL_STATS),
                Arguments.of("/fiat", Environment.URL_FIAT)
        );
    }
}
