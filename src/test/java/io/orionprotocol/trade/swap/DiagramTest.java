package io.orionprotocol.trade.swap;

import io.orionprotocol.BaseTest;
import io.orionprotocol.Environment;
import io.orionprotocol.pages.trade.page.SwapPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;


@Epic(value = "Тесты UI: trade.orionprotocol.io")
@Feature(value = "Swap")
@DisplayName("Тесты диаграммы")
public class DiagramTest extends BaseTest {

    @ParameterizedTest(name = "Период - {0}")
    @ValueSource(strings = {"1D", "1W", "1M", "1Y"})
    @DisplayName("Выбрать отчетный период для графика")
    void checkTimePeriodButtonsTest(String reportingPeriod) {
        open(Environment.URL_SWAP, SwapPage.class)
                .clickGotItButton()
                .checkTimePeriodButtons(reportingPeriod);
    }

    @Test
    @DisplayName("Тест открытия графика canvas")
    void openDiagramTest() {
        open(Environment.URL_SWAP, SwapPage.class)
                .clickGotItButton()
                .checkDiagram();
    }
}