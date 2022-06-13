//package io.orionprotocol.main;
//
//
//import io.orionprotocol.AppConfigProd;
//import io.orionprotocol.extention.ConfigExtension;
//import io.orionprotocol.main.page.MainPage;
//import io.qameta.allure.Epic;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import static com.codeborne.selenide.Selenide.open;
//
//@Epic(value = "Тесты UI: https://www.orionprotocol.io")
//@DisplayName("Тесты основной страницы")
//@ExtendWith(ConfigExtension.class)
//public class MainPageTest {
//
//    @Test
//    @DisplayName("Переход кнопки BUY ORN")
//    void checkTransitionBuyOrnButtonTest() {
//        open(AppConfigProd.URL_HOME, MainPage.class)
//                .clickBuyOrnButton()
//                .checkBuyButton();
//    }
//
//    @Test
//    @DisplayName("Переход кнопки TRADE NOW")
//    void checkTransitionTradeNowButtonTest() {
//        open(AppConfigProd.URL_HOME, MainPage.class)
//                .clickTradeNowButton()
//                .checkAddWalletButton();
//    }
//
//    @Test
//    @DisplayName("Переход кнопки OUR PARTNERS")
//    void checkTransitionOurPartnersButtonTest() {
//        open(AppConfigProd.URL_HOME, MainPage.class)
//                .clickOurPartnersButton()
//                .checkPartnerSiteOpening();
//    }
//
//    @Test
//    @DisplayName("Переход кнопки Join The Future")
//    void checkTransitionJoinTheFutureButton(){
//        open(AppConfigProd.URL_HOME,MainPage.class)
//                .clickJoinTheFutureButton()
//                .clickCloseButton();
//    }
//
//    @Test
//    @DisplayName("Отправить форму")
//    void sendMessageTest(){
//        open(AppConfigProd.URL_HOME, MainPage.class)
//                .clickJoinTheFutureButton()
//                .inputFieldForMessage();
//        //Todo: проверить в бд
//    }
//}
