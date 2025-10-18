package org.example.frontend.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Data
public class SuppliersPage implements HasNavigationBar {
    WebDriver driver;

    public SuppliersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
