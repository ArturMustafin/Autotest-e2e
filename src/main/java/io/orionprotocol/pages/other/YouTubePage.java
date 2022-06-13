package io.orionprotocol.pages.other;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class YouTubePage {

    @Step("Проверить название видео {0}")
    public YouTubePage checkNameVideo(String nameVideo) {
        $x("//h1/yt-formatted-string[contains(text(), '" + nameVideo + "')]")
                .shouldBe(visible)
                .shouldHave(text(nameVideo));
        return this;
    }

    @Step("Проверить Url страницы")
    public void checkUrlPage() {
        assertThat(WebDriverRunner.getWebDriver().getCurrentUrl())
                .contains("https://www.youtube.com/watch?v=WrKS8S1JzU8");
    }
}