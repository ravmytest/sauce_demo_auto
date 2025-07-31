package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SignupPage;

public class SignupTests {
    private WebDriver driver;
    private SignupPage signupPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://sauce-demo.myshopify.com/account/register");
        signupPage = new SignupPage(driver);
    }

    @Test
    public void testSignupWithValidData() {
        signupPage.signup("ME","TOO","testuser" + System.currentTimeMillis() + "@example.com", "Test@1234");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        // Adjust assertion as per actual success message
        Assert.assertTrue(signupPage.getSuccessMessage().toLowerCase().contains("success") 
            || signupPage.getSuccessMessage().toLowerCase().contains("check your email"));
    }

    @Test
    public void testSignupWithExistingEmail() {
//        signupPage.signup("existing@example.com", "Test@1234");
//        Assert.assertTrue(signupPage.getErrorMessage().toLowerCase().contains("already")
//            || signupPage.getErrorMessage().toLowerCase().contains("exists"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
