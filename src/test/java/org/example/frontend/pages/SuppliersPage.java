package org.example.frontend.pages;

import lombok.Data;
import org.example.frontend.pages.elements.SuppliersTableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class SuppliersPage implements HasNavigationBar {
    WebDriver driver;

    @FindBy(css = "table#suppliers-table tbody tr")
    List<WebElement> suppliersTableRows;

    public SuppliersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public SuppliersTableRow getTableRowByName(String name) {
        return suppliersTableRows.stream()
                .map(SuppliersTableRow::new)
                .filter(row -> row.getName().equals(name))
                .findFirst().orElseThrow();
    }

}
