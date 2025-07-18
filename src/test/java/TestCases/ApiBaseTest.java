package TestCases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeSuite;
import api.Utils.AuthHelper;

public class ApiBaseTest {

    protected static RequestSpecification requestSpec;
    protected static Cookie authCookie;

    @BeforeSuite
    public void setupApi() {
        System.out.println("Setting up API request specification...");
        authCookie = AuthHelper.getAuthCookie();

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://opensource-demo.orangehrmlive.com")
                .addCookie(String.valueOf(authCookie))
                .setContentType("application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
