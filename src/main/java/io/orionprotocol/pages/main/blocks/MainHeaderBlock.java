package io.orionprotocol.pages.main.blocks;

;
import com.codeborne.selenide.WebDriverRunner;
import io.orionprotocol.AppConfigProd;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MainHeaderBlock {

    @Step("Нажать на логотип")
    public MainHeaderBlock clickLogo() {
        $(By.className("header-logo")).click();
        return this;
    }

    @Step("Перейти на страницу {0}")
    public void goToPage(String page) {
        $x("//header[@class='header']//a[text()='" + page + "']").shouldBe(visible).click();
    }

    @Step("Проверить переход на страницу")
    public void checkPage() {
        assertThat(WebDriverRunner.getWebDriver().getCurrentUrl()).contains(AppConfigProd.URL_HOME);
    }
}
