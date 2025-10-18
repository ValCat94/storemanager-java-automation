package org.example.tests.frontend;

import org.example.frontend.models.User;
import org.example.frontend.pages.LoginPage;
import org.example.frontend.pages.ProductsPage;
import org.example.tests.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
        new LoginPage(driver).loginAs(testUser);
        new ProductsPage(driver).clickSuppliersLink();

        System.out.println();
    }

    private User useTestUser() {
        return User.builder().email("v@v.ru").password("12345678").build();
    }
}
