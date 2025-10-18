package org.example.frontend.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuppliersTableRow {
    WebElement root;

    public SuppliersTableRow(WebElement root) {
        this.root = root;
    }

    public String getName() {
        return root.findElement(By.xpath(".//td")).getText();
    }
}
