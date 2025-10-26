package org.example.tests.frontend;

import org.example.backend.models.SupplierCreateModel;
import org.example.frontend.models.User;
import org.example.frontend.pages.LoginPage;
import org.example.frontend.pages.ProductsPage;
import org.example.frontend.pages.SuppliersPage;
import org.example.tests.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreManagerUiTests extends BaseTest {

    User testUser;
    WebDriver driver;

    @BeforeEach
    void setupData() {
        // ArrangeS
        testUser = useTestUser();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(APP_UI_URL);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void loginTest() {
        // Act
        new LoginPage(driver).loginAs(testUser);

        // Assert
        ProductsPage productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isPersonalAccountDisplayed());
    }

    @Test
    void viewSupplierTest() {
        SupplierCreateModel createdSupplier = SupplierCreateModel.generate();

        new LoginPage(driver).loginAs(testUser);
        sleep(5000);
        new ProductsPage(driver).clickSuppliersLink();

        SupplierCreateModel actualSupplier = new SuppliersPage(driver)
                .getTableRowByName(createdSupplier.getName()).getSupplierCreateModel();
        assertEquals(createdSupplier, actualSupplier);
        sleep();

        new SuppliersPage(driver).getTableRowByName(createdSupplier.getName()).clickDeleteButton();
        sleep();

        driver.switchTo().alert().accept();
        assertTrue(new SuppliersPage(driver).isDeletedSupplierNotificationDisplayed());
        sleep();
    }

    private User useTestUser() {
        return User.builder().email("v2@v.ru").password("85456525").build();
    }
}