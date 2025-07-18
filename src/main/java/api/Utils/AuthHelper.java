package api.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.LoginPage;

public class AuthHelper {

    public static Cookie getAuthCookie() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        Cookie sessionCookie = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com");

            LoginPage loginPage = new LoginPage(driver); // Re-use your UI LoginPage
            loginPage.login("Admin","admin123");

            // Small wait to ensure cookie is set
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

            sessionCookie = driver.manage().getCookieNamed("orangehrm");
            if (sessionCookie == null) {
                throw new RuntimeException("Failed to retrieve authentication cookie.");
            }
        } catch (Exception e) {
            System.err.println("Error during authentication for cookie retrieval: " + e.getMessage());
            throw e; // Re-throw to indicate failure
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
        return sessionCookie;
    }
}