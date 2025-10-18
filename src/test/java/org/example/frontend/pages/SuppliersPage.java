package org.example.frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuppliersPage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(.,'Личный кабинет')]")
    WebElement personalAccount;

    public SuppliersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isPersonalAccountDisplayed() {
        return personalAccount.isDisplayed();
    }
}
