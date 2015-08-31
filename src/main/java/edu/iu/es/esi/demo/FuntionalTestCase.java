package edu.iu.es.esi.demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class FuntionalTestCase {

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "width", "baseUrl" })
    public void setup(String browserName, String widthName, String baseUrl) {
        Browser browser = Browser.getBrowser(browserName);
        BrowserWidth width = BrowserWidth.getWidth(widthName);
        WebDriver driver = new WebDriver(browser, width, baseUrl);
        driver.initialize();
        WebDriverContext.setCurrentDriver(driver);
        System.out.println("setup " + driver.getBrowserName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = WebDriverContext.getCurrentDriver();
        driver.quit();
        WebDriverContext.clearCurrentDriver();
    }

    public <T extends PageBase> T navigateTo(Class<T> pageClass) {
        try {
            WebDriver driver = WebDriverContext.getCurrentDriver();
            String pagePath = pageClass.getAnnotation(Page.class).value();
            driver.get(driver.getBaseUrl() + pagePath);
            return pageClass.newInstance();
        } catch ( InstantiationException | IllegalAccessException e ) {
            throw new RuntimeException(e);
        }
    }

}
