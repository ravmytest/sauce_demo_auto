package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTests {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://sauce-demo.myshopify.com/account/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testInvalidLoginShowsError() {
        loginPage.login("invalid@example.com", "wrongpassword");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(loginPage.getErrorMessage().contains("incorrect"), "Error message not shown");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
