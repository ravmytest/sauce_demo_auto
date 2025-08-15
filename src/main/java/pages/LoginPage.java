package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By emailField = By.id("customer_email");
    private By passwordField = By.id("customer_password");
    private By loginButton = By.xpath("//div[@class='action_bottom']//input[@value='Sign In']");
    private By errorMessage = By.xpath("//div[@class='errors']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) throws InterruptedException {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
