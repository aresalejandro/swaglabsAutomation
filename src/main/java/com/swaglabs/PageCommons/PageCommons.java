package com.swaglabs.PageCommons;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.swaglabs.core.DriverService;
import com.swaglabs.core.PropertyManager;

import java.util.concurrent.TimeUnit;

public abstract class PageCommons {

    public void goToBaseUrl(){
        DriverService.getDriverInstance().get(PropertyManager.getProperty("base.url"));
    }
    
    public WebElement getElement(By locator) {
        return DriverService.getDriverInstance().findElement(locator);
    }

    public String getText(By locator){
        WebElement element = getElement(locator);
        return getText(element);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void setInput(By locator, String value) {
        WebElement element = getElement(locator);
        element.sendKeys(value);
    }

    public void click(By locator) {
        WebElement element = getElement(locator);
        element.click();
    }

    public boolean isPresent(By locator) {
        DriverService.getDriverInstance().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            getElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            DriverService.getDriverInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
    }

}
