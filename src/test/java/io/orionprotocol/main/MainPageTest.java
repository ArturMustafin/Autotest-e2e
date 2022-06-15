//package io.orionprotocol.main;
//
//
//import io.orionprotocol.BaseTest;
//import io.orionprotocol.Environment;
//import io.orionprotocol.pages.main.page.MainPageMain;
//import io.qameta.allure.Epic;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static com.codeborne.selenide.Selenide.open;
//
//@Epic(value = "Тесты UI: https://www.orionprotocol.io")
//@DisplayName("Тесты главной страницы")
////@ExtendWith(ConfigExtension.class)
//public class MainPageTest extends BaseTest {
//
//    @Test
//    @DisplayName("Переход кнопки BUY ORN")
//    void checkTransitionBuyOrnButtonTest() {
//        open(Environment.URL_HOME, MainPageMain.class)
//                .clickBuyOrnButton()
//                .checkBuyButton();
//    }
//
//    @Test
//    @DisplayName("Переход кнопки TRADE NOW")
//    void checkTransitionTradeNowButtonTest() {
//        open(Environment.URL_HOME, MainPageMain.class)
//                .clickTradeNowButton()
//                .checkSwapWebsite();
//    }
//
//    @Test
//    @DisplayName("Переход кнопки OUR PARTNERS")
//    void checkTransitionOurPartnersButtonTest() {
//        open(Environment.URL_HOME, MainPageMain.class)
//                .clickOurPartnersButton()
//                .checkPartnerSiteOpening();
//    }
//
//    @Test
//    @DisplayName("Переход кнопки Join The Future")
//    void checkTransitionJoinTheFutureButton(){
//        open(Environment.URL_HOME,MainPageMain.class)
//                .clickJoinTheFutureButton()
//                .clickCloseButton();
//    }
//
//    @Test
//    @DisplayName("Отправить форму")
//    void sendMessageTest(){
//        open(Environment.URL_HOME, MainPageMain.class)
//                .clickJoinTheFutureButton()
//                .inputFieldForMessage();
//        //Todo: проверить в бд
//    }
//}
