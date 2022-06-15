package io.orionprotocol.pages.trade.page;

import com.codeborne.selenide.SelenideElement;
import io.orionprotocol.pages.other.YouTubePage;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Страница "Swap"
 */
public class SwapPage extends TradeBasePage {

    private final SelenideElement inputFieldFrom = $x("//label[@class='InputText_root__2Cgmo SwapSpending_input__dubuc']/input");
    private final SelenideElement inputFieldTo = $x("//label[@class='InputText_root__2Cgmo SwapReceiving_input__3lo_m']/input");


    //=================================================== Form swap ====================================================
    @Step("Нажать на кнопку 'Add Wallet'")
    public SwapPage clickAddWalletButton() {
        $x("//button[text()='Add Wallet']")
                .shouldBe(visible, ofSeconds(6))
                .shouldHave(text("Add Wallet"))
                .click();
        return this;
    }

    @Step("Ввод случайных чисел в поле From (exact)")
    public SwapPage enterRandomNumbersInFieldFrom() {
        inputFieldFrom.setValue(RandomStringUtils.randomNumeric(5));
        return this;
    }

    @Step("Проверить поле ввода To = !null")
    public void checkInputFieldTo() {
        assertNotNull(inputFieldTo
                .shouldBe(visible, ofSeconds(6))
                .getAttribute("value"));
    }

    @Step("Ввод случайных чисел в поле To (exact)")
    public SwapPage enterRandomNumbersInFieldTo() {
        actions()
                //нужен клик, без него элемент не видимый
                .click(inputFieldTo)
                .sendKeys(RandomStringUtils.randomNumeric(5))
                .perform();
        return this;
    }

    @Step("Проверить поле ввода From = !null")
    public void checkInputFieldFrom() {
        assertNotNull(inputFieldFrom
                .shouldBe(visible, ofSeconds(6))
                .getAttribute("value"));
    }

    //картинки токенов в dropDown
//    private final SelenideElement dropDownFormTokenButton = $x("//div[@class='SwapSpending_currencyPicker__fZoFP']");
//    private final SelenideElement dropDownToTokenButton = $(By.className("SwapReceiving_currencyPicker__38Eqi"));
//    public void getList() {
//        //private final ElementsCollection tokens = $$x("//div[@class='SwapFieldDropdown_searchResult__DpMxi']//div[@class='Icon_root__1SgNj Icon_currency__38BiG Icon_theme__2vDcE CryptoCurrency_iconWrapper__1EyyP']");
//
//        List<String> links = new ArrayList<>();
//        int a = 0;
//        int b = 0;
//        dropDownFormTokenButton.shouldBe(visible, Duration.ofSeconds(5)).click();
//        System.out.println(tokens.size());
//        tokens.stream();
//        int c = 0;
//    }


    //=========================================== Welcome to Orion Terminal! ===========================================
    @Step("Нажать на кнопку 'Got it!'")
    public SwapPage clickGotItButton() {
        $x("//button[text()='Got it!']").click();
        return this;
    }

    @Step("Нажать на гиперссылку: {0}")
    public YouTubePage clickLearnHowToTrade(String text) {
        $x("//a[text()='" + text + "']")
                .shouldBe(visible,ofSeconds(6)).click();
        switchTo().window(1);
        return page(YouTubePage.class);
    }

    @Step("Нажать на текст: 'Add your wallet'")
    public SwapPage clickTextAddYourWallet() {
        $x("//div[text()='Add your wallet']")
                .shouldBe(visible,ofSeconds(6))
                .click();
        return this;
    }

    @Step("Проверить переход в /swap")
    public void checkSwapWebsite() {
        $x("//h1[text()='Welcome to Orion Terminal!']")
                .shouldBe(visible, ofSeconds(6))
                .shouldHave(text("Welcome to Orion Terminal!"));
    }


    //=================================================== Диаграмма ====================================================
    @Step("Проверить наличие диаграмму")
    public void checkDiagram() {
        $x("//div[@class='chartjs-size-monitor']/../canvas")
                .shouldBe(visible, ofSeconds(6));
    }

    @Step("Проверить кнопку {0}")
    public void checkTimePeriodButtons(String reportingPeriod) {
        assertTrue(
                $x("//div[@class='SwapChart_toolbar__16M92']//div[text()='" + reportingPeriod + "']")
                        .shouldBe(visible, ofSeconds(6))
                        .isDisplayed());
    }


    //====================================================== FEE =======================================================
    @Step("Нажать: 'How to reduce fee?'")
    public SwapPage clickHowToReduceFee() {
        $x("//div[text()='How to reduce fee?']")
                .shouldBe(visible, ofSeconds(6)).click();
        return this;
    }

    @Step("Проверить popup на текст: 'Pay less fee per trade'")
    public SwapPage checkTextPayLessFeePopup() {
        $x("//div[@class='Popup_popup__1RZqf']//div[text()='Pay less fee per trade']")
                .shouldBe(visible)
                .shouldHave(text("Pay less fee per trade"));
        return this;
    }

    @Step("Нажать закрыть: Pay less fee per trade(popup)")
    public void closeFeePopup() {
        $x("//div[@class='Popup_closeButtonWrapper__3gYz3']").click();
    }
}
