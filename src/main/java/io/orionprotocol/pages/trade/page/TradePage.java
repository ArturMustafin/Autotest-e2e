package io.orionprotocol.pages.trade.page;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.*;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


/**
 * Страница "Trade"
 */
public class TradePage extends TradeBasePage {

    private Map<String, String> tableData;


    //======================================= Контейнер для выбора торговых пар ========================================
    private final SelenideElement lastPriceButton = $x("//span[text()='Last price']");
    private final SelenideElement inputSearch = $x("//label[@class='InputText_root__2Cgmo TradePairSelector_searchInput__1qrMS']/input");

    //================================================== Form Trade ====================================================

    //================================================== Диаграмма =====================================================

    //================================================ Trade History ===================================================

    //================================================== Order Book ====================================================
    private final ElementsCollection orders = $$(By.cssSelector(".TradeOrderBookItem_root__1kdzi"));


    public TradePage() {
        selectTitle();
    }


    //======================================= Контейнер для выбора торговых пар ========================================

    @Step("Нажать на пару")
    public TradePage clickContainerPair() {
        $(By.className("Trade_pair__3gYz8")).click();
        return this;
    }

    @Step("Проверить открытые контейнера торговых пар")
    public void checkOpenContainerPair() {
        lastPriceButton.shouldBe(visible)
                .shouldHave(text("Last price"));
    }

    @Step("Ввести токен: {0}")
    public TradePage inputToken(String token) {
        inputSearch.shouldBe(visible, ofSeconds(6)).setValue(token);
        return this;
    }

    @Step("Проверить найденный токена: {0}")
    public void checkFoundToken(String token) {
        $$(By.className("TradePairSelector_colTokenWhite__1U8oa")).get(0)
                .shouldBe(text(token));
    }

    @Step("Нажать на поле: {0}")
    public TradePage clickTableHead(String tableHead) {
        Map<String, String> headersTable = new HashMap<>();
        headersTable.put("Pair", "pairNameColumn");
        headersTable.put("Networks", "networksLengthColumn");
        headersTable.put("Last price", "lastPriceColumn");
        headersTable.put("Volume", "vol24hColumn");
        headersTable.put("Change", "change24hColumn");

        $(By.className(headersTable.get(tableHead))).click();
        return this;
    }

    @Step("Проверка сортировки")
    public void checkSort(String tableHead) {
        List<String> actualListTokens = new ArrayList<>();

        $$(By.cssSelector(tableData.get(tableHead))).listIterator()
                .forEachRemaining(x -> actualListTokens.add(x.getText()));

        List<String> expectedListTokens = new ArrayList<>(actualListTokens);
        Collections.sort(expectedListTokens);

        assertIterableEquals(expectedListTokens, actualListTokens);
    }

    //================================================== Form Trade ====================================================

    //================================================== Диаграмма =====================================================

    //================================================ Trade History ===================================================

    //================================================== Order Book ====================================================

    @Step("Нажать на текст: Virtual paths")
    public TradePage clickVirtualPath() {
        $x("//div[text()='Virtual paths']")
                .shouldBe(visible, ofSeconds(6)).click();
        return this;
    }

    @Step("Проверить order books sizeNotEqual = 0")
    public void checkOrderBooksNoNull() {
        orders.should(sizeNotEqual(0), ofSeconds(6));
    }

    @Step("проверка иконок токена в списке orders")
    public void checkImgInOrderBooks() {
        List<SelenideElement> imgs = new ArrayList<>();
        orders.listIterator()
                .forEachRemaining(x -> imgs.add(x.$(By.cssSelector(".styles_container__3K9tk"))));
        //todo в списке (.TradeOrderBookItem_root__1kdzi) есть  (.styles_container__3K9tk) и без него
    }


    private void selectTitle() {
        tableData = new HashMap<>();
        tableData.put("Pair", ".TradePairSelector_colTokenWhite__1U8oa");
        tableData.put("Networks", ".TradePairSelector_icons__2zGoh");
        tableData.put("Last price", ".TradePairSelector_lastPriceCell__K8Uof .TradePairSelector_colNumberWhite__3NsBY");
        tableData.put("Volume", ".TradePairSelector_vol24hCell__1fmOj .TradePairSelector_colNumberWhite__3NsBY");
    }
}