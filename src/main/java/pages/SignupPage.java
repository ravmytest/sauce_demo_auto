package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {
	
	private By firstName = By.xpath("//input[@id='first_name']");
	private By lastName = By.xpath("//input[@id='last_name']");
    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signupButton = By.xpath("//div[@class='action_bottom']//input[@value='Create']");
    
    private By errorMessage = By.cssSelector(".form-message--error");
    private By successMessage = By.cssSelector(".form-message--success");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void signup(String fname, String lname, String email, String password) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signupButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
