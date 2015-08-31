package edu.iu.es.esi.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebDriver implements org.openqa.selenium.WebDriver {

    private static int BROWSER_HEIGHT = 1024;

    private Browser browser;
    private BrowserWidth width;
    private String baseUrl;
    private org.openqa.selenium.WebDriver realDriver;

    public WebDriver(Browser browser, BrowserWidth width, String baseUrl) {
        this.browser = browser;
        this.width = width;
        this.baseUrl = baseUrl;
    }

    public void initialize() {
        this.realDriver = browser.getDriverInstance();
        this.realDriver.manage().window().setSize(new Dimension(width.getWidth(), BROWSER_HEIGHT));
    }

    public String getBrowserName() {
        return browser.getName();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    private void performDriverCheck() {
        if(realDriver == null) {
            throw new DriverNotInitializedException();
        }
    }

    @Override
    public void get(String s) {
        performDriverCheck();
        realDriver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        performDriverCheck();
        return realDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        performDriverCheck();
        return realDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        performDriverCheck();
        return realDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        performDriverCheck();
        return realDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        performDriverCheck();
        return realDriver.getPageSource();
    }

    @Override
    public void close() {
        performDriverCheck();
        realDriver.close();
    }

    @Override
    public void quit() {
        performDriverCheck();
        realDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        performDriverCheck();
        return realDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        performDriverCheck();
        return realDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        performDriverCheck();
        return realDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        performDriverCheck();
        return realDriver.navigate();
    }

    @Override
    public Options manage() {
        performDriverCheck();
        return realDriver.manage();
    }
}
