//package io.orionprotocol.main;
//
//import com.codeborne.selenide.WebDriverRunner;
//import io.orionprotocol.AppConfigProd;
//import io.orionprotocol.BaseTest;
//import io.orionprotocol.extention.ConfigExtension;
//import io.orionprotocol.main.page.*;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.stream.Stream;
//
//import static com.codeborne.selenide.Selenide.*;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(ConfigExtension.class)
//public class MainHeaderBlockTest extends BaseTest {
//
//    @Test
//    void checkLogoTest() {
//        open(AppConfigProd.URL_HOME, MainPage.class)
//                .getHeaderBlock()
//                .clickLogo()
//                .checkPage();
//    }
//
//
//    @ParameterizedTest(name = "Перейти на страницу - {0}")
//    @MethodSource("dataListForMenu")
//    void checkMenuHeaderTest(String nameMenu, String url) {
//        open(AppConfigProd.URL_HOME, MainPage.class)
//                .getHeaderBlock()
//                .goToPage(nameMenu);
//
//        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
//
//        assertThat(currentUrl).contains(url);
//    }
//
//    private static Stream<Arguments> dataListForMenu() {
//        return Stream.of(
//                Arguments.of("Bridge", AppConfigProd.URL_BRIDGE),
//                Arguments.of("IDOs", AppConfigProd.URL_SOLARFLARE),
//                //Arguments.of("Swap Widget", AppConfig.URL_WIDGET),       отдельный тест Dropdown список
//                //Arguments.of("NFT Aggregator", AppConfig.URL_NFTAGGREGATOR),      отдельный тест Dropdown список
//                //Arguments.of("Liquidity Boost Plugin", AppConfig.URL_LIQUIDITYBOOSTPLUGIN),      отдельный тест Dropdown список
//                //Arguments.of("Blockchain DEX Kit", AppConfig.URL_DEXKIT),      отдельный тест Dropdown список
//                //Arguments.of("Enterprise Trade Widget", AppConfig.URL_ENTERPRISETRADE),      отдельный тест Dropdown список
//                //Arguments.of("Launchpad Liquidity", AppConfig.URL_LAUNCHPAD),      отдельный тест Dropdown список
//                //Arguments.of("Developer Kit", AppConfig.URL_DEVELOPERKIT),      отдельный тест Dropdown список
//                Arguments.of("ORN", AppConfigProd.URL_ORN),
//                Arguments.of("Partners", AppConfigProd.URL_PARTNERS),
//                //Arguments.of("Developer Kit", AppConfig.URL_DEVELOPERKIT),      отдельный тест Dropdown список
//                Arguments.of("About", AppConfigProd.URL_ABOUT)
//        );
//    }
//}
