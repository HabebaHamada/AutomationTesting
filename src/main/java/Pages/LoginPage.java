package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameInputLocator = By.name("username");
    private final By passwordInputLocator = By.name("password");
    private final By loginButtonLocator = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public DashboardPage login(String username, String password) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLocator));
        usernameInput.sendKeys(username);

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputLocator));
        passwordInput.sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginButton.click();

        return new DashboardPage(driver);
    }

}
