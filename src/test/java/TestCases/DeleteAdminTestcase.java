package TestCases;

import Pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class DeleteAdminTestcase extends BaseTest {


    @Test
    public void AdminUserDeleteTestcase() {

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Admin User Delete Testcase Started : ");

        // 1. Navigate to the URL
        driver.get("https://opensource-demo.orangehrmlive.com");

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboardPage = loginPage.login("Admin","admin123");

        /*Validate that Dashboard Page is loaded*/
        Assert.assertTrue(dashboardPage.isPageLoaded(), "Did not navigate to the 'Dashboard Page' page.");

        /*Navigating to the Admin Tab*/
        AdminPage adminPage = dashboardPage.clickAdminTab();

        adminPage.searchByUsername("Admin");

        HashMap searchResultData =adminPage.getResults();

        System.out.println("Verifying search results...");

        softAssert.assertTrue(adminPage.getNoOfRecords().contains("(1) Record Found"),
                "Assertion Failed: Record count text is incorrect.");

        softAssert.assertEquals(searchResultData.get("UserName"), "Admin",
                "Assertion Failed: Username in result is incorrect.");

        softAssert.assertEquals(searchResultData.get("UserRole"), "Admin",
                "Assertion Failed: User role in result is incorrect.");

        softAssert.assertEquals(searchResultData.get("Status"), "Enabled",
                "Assertion Failed: Status in result is incorrect.");

        System.out.println("Attempting to delete the Admin user...");

        adminPage.attemptToDeleteUser();

        softAssert.assertTrue(adminPage.getNoOfRecords().contains("(1) Record Found"),
                "Assertion Failed: Admin user was deleted, which should not be allowed.");

        softAssert.assertTrue(adminPage.getToastMessage().contains("Cannot be deleted"),
                "Assertion Failed: Admin user was deleted, which should not be allowed.");
        softAssert.assertAll();
    }

}
