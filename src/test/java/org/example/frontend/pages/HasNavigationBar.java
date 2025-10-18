package org.example.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface HasNavigationBar {

    WebDriver getDriver();

    default boolean isPersonalAccountDisplayed() {
        return getDriver().findElement(
                By.xpath("//nav//a[contains(.,'Личный кабинет')]")).isDisplayed();
    }
}
