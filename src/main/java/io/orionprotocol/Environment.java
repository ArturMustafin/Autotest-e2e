package io.orionprotocol;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Environment {

    static InputStream inputStream;
    static Properties property = new Properties();

    /**
     * Адреса trade.orionprotocol.io
     */
    public static final String URL_SWAP = getUlr("SWAP");
    public static final String URL_TRADE = getUlr("TRADE");
    public static final String URL_DASHBOARD_BRIDGE = getUlr("DASHBOARD_BRIDGE");
    public static final String URL_DASHBOARD = getUlr("DASHBOARD");
    public static final String URL_GOVERNANCE = getUlr("GOVERNANCE");
    public static final String URL_POOLS = getUlr("POOLS");
    public static final String URL_IDO = getUlr("IDO");
    public static final String URL_STATS = getUlr("STATS");
    public static final String URL_FIAT = getUlr("FIAT");

    /**
     * Адреса orionprotocol.io
     */
    public static final String URL_HOME = getUlr("HOME");
    public static final String URL_BRIDGE = getUlr("BRIDGE");
    public static final String URL_SOLAR_FLARE = getUlr("SOLAR_FLARE");
    public static final String URL_ORN = getUlr("ORN");
    public static final String URL_PARTNERS = getUlr("PARTNERS");
    public static final String URL_ABOUT = getUlr("ABOUT");
    public static final String URL_WIDGET = getUlr("WIDGET");
    public static final String URL_NFT_AGGREGATOR = getUlr("NFT_AGGREGATOR");
    public static final String URL_LIQUIDITY_BOOST_PLUGIN = getUlr("LIQUIDITY_BOOST_PLUGIN");
    public static final String URL_DEX_KIT = getUlr("DEX_KIT");
    public static final String URL_ENTER_PRISE_TRADE = getUlr("ENTER_PRISE_TRADE");
    public static final String URL_LAUNCHPAD = getUlr("LAUNCHPAD");
    public static final String URL_DEVELOPER_KIT = getUlr("DEVELOPER_KIT");
    public static final String URL_RESOURCES = getUlr("RESOURCES");
    public static final String URL_BLOG = getUlr("BLOG");
    public static final String URL_NEWS = getUlr("NEWS");

    /**
     * Загрузка пропертей
     */
    private static Properties loadProperties() {
        try {
            inputStream = Environment.class.getClassLoader().getResourceAsStream("conf.properties");
            property.load(inputStream);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсутствует!");
        }
        return property;
    }

    /**
     * Получение URL
     */
    private static String getUlr(String param) {
        return loadProperties().getProperty(param);
    }
}
