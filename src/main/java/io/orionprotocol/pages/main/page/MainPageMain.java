package io.orionprotocol.pages.main.page;


import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.orionprotocol.pages.trade.page.FiatPage;
import io.orionprotocol.pages.trade.page.SwapPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageMain extends MainBasePage {

    private final SelenideElement fieldName = $(By.xpath("//div[@id='contacts']//input[@name='firstname']"));
    private final SelenideElement fieldEmail = $(By.xpath("//div[@id='contacts']//input[@name='email']"));
    private final SelenideElement selectMenu = $(By.name("select_subject"));
    private final SelenideElement fieldMessage = $(By.xpath("//div[@id='contacts']//textarea[@name='message']"));
    private final SelenideElement buttonSend = $(By.xpath("//input[@value='Send']"));

    @Step("Нажать на кнопку 'Buy ORN'")
    public FiatPage clickBuyOrnButton() {
        $(By.xpath("//a[contains(text(), 'Buy ORN')]")).click();
        return page(FiatPage.class);
    }

    @Step("Нажать на кнопку 'TRADE NOW'")
    public SwapPage clickTradeNowButton() {
        $(By.xpath("//a[contains(text(), 'TRADE NOW')]")).click();
        return page(SwapPage.class);
    }

    @Step("Нажать на кнопку 'JOIN THE FUTURE'")
    public MainPageMain clickJoinTheFutureButton() {
        $(By.xpath("//a[contains(text(), 'JOIN THE FUTURE')]")).click();
        return this;
    }

    @Step("Нажать на кнопку 'OUR PARTNERS'")
    public PartnersPage clickOurPartnersButton() {
        $(By.xpath("//a[contains(text(), 'OUR PARTNERS')]")).click();
        return page(PartnersPage.class);
    }

    @Step("Нажать на кнопку закрыть")
    public void clickCloseButton() {
        $(By.xpath("//div[@id='contacts']//a[@class='modal-close']")).shouldBe(visible).click();
    }

    @Step("Заполнить форму валидными данными")
    public void inputFieldForMessage() {
        Faker faker = new Faker();

        fieldName.setValue(faker.name().firstName());
        fieldEmail.setValue(faker.internet().emailAddress());
        selectMenu.selectOption(3);
        fieldMessage.setValue(faker.rickAndMorty().character());
        buttonSend.click();
    }
}