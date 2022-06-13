package io.orionprotocol.pages.trade.blocks;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class LeftNavigation {

    @Step("Перейти в endPoint: {0}")
    public LeftNavigation goToPage(String endPoint) {
        $x("//div[@class='styles_container__3iaUc']/div/a[@href='" + endPoint + "']").click();
        return this;
    }

    @Step("Проверить Url страницы")
    public void checkUrlPage(String url) {
        assertThat(WebDriverRunner.getWebDriver().getCurrentUrl()).contains(url);
    }
}