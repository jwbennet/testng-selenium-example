package edu.iu.es.esi.demo;

public class WebDriverContext {

    private static final ThreadLocal<WebDriver> CURRENT_DRIVER = new ThreadLocal<>();

    public static WebDriver getCurrentDriver() {
        return CURRENT_DRIVER.get();
    }

    public static void setCurrentDriver(WebDriver driver) {
        CURRENT_DRIVER.set(driver);
    }

    public static void clearCurrentDriver() {
        CURRENT_DRIVER.remove();
    }
}
