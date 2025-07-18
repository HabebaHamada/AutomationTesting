OrangeHRM Automation Project
This project demonstrates automated testing for the OrangeHRM open-source application using Selenium for UI tests and REST Assured for API tests.

Tools Used
1.Java Development Kit (JDK): Version 17 or higher recommended (project uses Java 23 for demonstration).
2.Maven: Build automation tool for dependency management, compilation, and test execution.
3.IntelliJ IDEA (Community Edition): Integrated Development Environment (IDE) for writing and running code.
4.Selenium WebDriver: For automating browser interactions (UI tests).
5.WebDriverManager: Automatically manages browser driver binaries (e.g., ChromeDriver).
6.TestNG: Testing framework for organizing tests, assertions, and managing test execution.
7.REST Assured: Library for testing RESTful APIs.
8.Jackson Databind: For serializing Java objects to JSON and vice versa for API requests/responses.
9.Java Faker: For generating realistic test data (used in API tests).
10.Google Chrome: The browser used for UI tests.
11.rangeHRM: The website under test.

Setup Instructions
Prerequisites
1.Install Java JDK:
Download and install Java Development Kit (JDK). Version 17 or later is recommended.
Ensure your JAVA_HOME environment variable is set correctly to your JDK installation directory.
Verify installation: Open your terminal/command prompt and run java -version and javac -version.

2.Install Maven:
Download and install Apache Maven.
Ensure your MAVEN_HOME environment variable is set correctly and that Maven's bin directory is added to your system's PATH.
Verify installation: Open your terminal/command prompt and run mvn -version.

3.Install IntelliJ IDEA:
Download and install IntelliJ IDEA Community Edition (or Ultimate).
Ensure the TestNG plugin is installed and enabled (it usually is by default).

4.Install a Web Browser:
Google Chrome is used in this project. Ensure it's installed on your system.

How to Run the Tests
1.Running UI Tests (Selenium)
Ensure Browser and Driver are Ready:
WebDriverManager, configured in BaseTest.java, will automatically download the correct ChromeDriver version for your installed Chrome browser.
Run the UI Test:
Open the OrangeHrmTest.java file (located in src/test/java/Testcases/).
Right-click anywhere within the code editor of DeleteAdminTestcase.java.
Select Run 'DeleteAdminTestcase'.
Alternatively, you can right-click on the testng.xml file and select Run 'testng.xml' (if you have UI tests included there).

2.Running API Tests (REST Assured)
For AuthHelper to get the cookie, your local machine needs access to opensource-demo.orangehrmlive.com.
If the AuthHelper fails, ensure you have a stable internet connection and no VPN/proxy is blocking Selenium.
Run the API Test:
Open the RecruitmentTest.java file (located in src/test/java/Testcases/).
Right-click anywhere within the code editor of AddCandidateApiTest.java.
Select Run 'AddCandidateApiTest'.
