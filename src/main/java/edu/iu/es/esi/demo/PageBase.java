package edu.iu.es.esi.demo;

import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {

    protected WebDriver driver;

    public PageBase() {
        this.driver = WebDriverContext.getCurrentDriver();
        PageFactory.initElements(driver, this);
    }
}
