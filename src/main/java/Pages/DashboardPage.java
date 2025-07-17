package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By adminTabLocator = By.xpath("//a[contains(@href, '/web/index.php/admin/viewAdminModule')]");
    private final By dashboardHeaderLocator = By.xpath("//h6[text()='Dashboard']");


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isPageLoaded()
    {
        boolean dashboardHeaderValidation=  wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeaderLocator)).isDisplayed();
        return  dashboardHeaderValidation;
    }

    public AdminPage clickAdminTab() {
        WebElement adminTab = wait.until(ExpectedConditions.elementToBeClickable(adminTabLocator));
        adminTab.click();
        return new AdminPage(driver);
    }
}
