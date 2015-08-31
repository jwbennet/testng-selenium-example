package edu.iu.es.esi.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.*;

public enum Browser {
    CHROME("chrome", ChromeDriver.class),
    FIREFOX("firefox", FirefoxDriver.class),
    INTERNET_EXPLORER("internet-explorer", InternetExplorerDriver.class),
    SAFARI("safari", SafariDriver.class);

    private final String name;
    private final Class<? extends WebDriver> driverClass;

    private Browser(String name, Class<? extends WebDriver> driverClass) {
        this.name = name;
        this.driverClass = driverClass;
        if(name.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/java/tools/chromedriver.exe");
        } else if(name.equals("internet-explorer")) {
            System.setProperty("webdriver.ie.driver", "/java/tools/iedriver.exe");
        }
    }

    public String getName() {
        return name;
    }

    public WebDriver getDriverInstance() {
        try {
            return this.driverClass.newInstance();
        } catch ( InstantiationException | IllegalAccessException  e) {
            throw new RuntimeException(e);
        }
    }

    public static Browser getBrowser(String browserName) {
        for( Browser browser : Browser.values() ) {
            if(browser.getName().equals(browserName)) {
                return browser;
            }
        }
        throw new IllegalStateException("Attempted to retrieve unsupported browser: " + browserName);
    }

    public static Collection<Browser> getBrowsers(String... browserNames) {
        List<String> browserList = Arrays.asList(browserNames);
        List<Browser> browsers = new ArrayList<>();
        for( Browser browser : Browser.values() ) {
            if( browserList.contains(browser.getName()) ) {
                browsers.add(browser);
            }
        }
        return browsers;
    }

}
