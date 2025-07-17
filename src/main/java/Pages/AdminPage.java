package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class AdminPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameSearchInputLocator = By.xpath("//label[text()='Username']/following::input[1]");
    private final By searchButtonLocator = By.xpath("//button[@type='submit']");
    private final By deleteIconLocator = By.xpath("//div[@class='oxd-table-body']//i[contains(@class, 'bi-trash')]");

    private final By recordHeaderLocator = By.cssSelector("div.orangehrm-paper-container > div:nth-child(2) > div > span");

    private final By firstRowUsernameLocator = By.xpath("//div[@class='oxd-table-body']/div[1]/div/div[2]/div");
    private final By firstRowUserRoleLocator = By.xpath("//div[@class='oxd-table-body']/div[1]/div/div[3]/div");
    private final By firstRowStatusLocator = By.xpath("//div[@class='oxd-table-body']/div[1]/div/div[5]/div");

    private final By toastMessageLocator = By.xpath("//div[contains(@class, 'oxd-toast-content')]//p[2]");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchByUsername(String username) {
        WebElement usernameSearchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSearchInputLocator));
        usernameSearchInput.sendKeys(username);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
    }

    public String getNoOfRecords()
    {
        WebElement recordHeader=wait.until(ExpectedConditions.visibilityOfElementLocated(recordHeaderLocator));
        return recordHeader.getText();
    }

    public HashMap getResults()
    {
        HashMap<String,String>Results = new HashMap<>();;

        WebElement firstRowUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowUsernameLocator));
        Results.put("UserName",firstRowUsername.getText());

        WebElement firstRowUserRole = wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowUserRoleLocator));
        Results.put("UserRole",firstRowUserRole.getText());

        WebElement firstRowStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowStatusLocator));
        Results.put("Status",firstRowStatus.getText());
        return Results;
    }

    public void attemptToDeleteUser() {

        WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(deleteIconLocator));
        deleteIcon.click();
    }

    public String getToastMessage()
    {
        WebElement toastMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessageLocator));
        return toastMessage.getText();
    }
}
