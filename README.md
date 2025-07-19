# OrangeHRM Automation Project

This project demonstrates automated testing for the OrangeHRM open-source application using Selenium for UI tests and REST Assured for API tests.

## Tools Used

1.  **Java Development Kit (JDK):** Version 17 or higher recommended (project uses Java 23 for demonstration).
2.  **Maven:** Build automation tool for dependency management, compilation, and test execution.
3.  **IntelliJ IDEA (Community Edition):** Integrated Development Environment (IDE) for writing and running code.
4.  **Selenium WebDriver:** For automating browser interactions (UI tests).
5.  **WebDriverManager:** Automatically manages browser driver binaries (e.g., ChromeDriver).
6.  **TestNG:** Testing framework for organizing tests, assertions, and managing test execution.
7.  **REST Assured:** Library for testing RESTful APIs.
8.  **Jackson Databind:** For serializing Java objects to JSON and vice versa for API requests/responses.
9.  **Java Faker:** For generating realistic test data (used in API tests).
10. **Google Chrome:** The browser used for UI tests.
11. **OrangeHRM:** The website under test.

## Setup Instructions

### Prerequisites

1.  **Install Java JDK:**
    *   Download and install Java Development Kit (JDK). Version 17 or later is recommended.
    *   Ensure your `JAVA_HOME` environment variable is set correctly to your JDK installation directory.
    *   Verify installation: Open your terminal/command prompt and run `java -version` and `javac -version`.

2.  **Install Maven:**
    *   Download and install Apache Maven.
    *   Ensure your `MAVEN_HOME` environment variable is set correctly and that Maven's `bin` directory is added to your system's `PATH`.
    *   Verify installation: Open your terminal/command prompt and run `mvn -version`.

3.  **Install IntelliJ IDEA:**
    *   Download and install IntelliJ IDEA Community Edition (or Ultimate).
    *   Ensure the TestNG plugin is installed and enabled (it usually is by default).

4.  **Install a Web Browser:**
    *   Google Chrome is used in this project. Ensure it's installed on your system.

### Project Setup Steps

1.  **Clone the Repository (if applicable):** If this project is in a Git repository, clone it to your local machine.
2.  **Open Project in IntelliJ:**
    *   Open IntelliJ IDEA.
    *   Select `File` -> `Open...`.
    *   Navigate to and select the root directory of this project.
    *   IntelliJ will prompt you to open it as a Maven project. Click **Yes**.
3.  **Load Maven Dependencies:**
    *   Once the project is open, IntelliJ will detect the `pom.xml` file.
    *   If IntelliJ doesn't automatically start downloading dependencies, go to the Maven tool window (usually on the right side of the screen), click the **Reload All Maven Projects** button (looks like a circular arrow).
    *   Wait for all dependencies to download.
4.  **Configure IntelliJ for Test Sources:**
    *   Go to `File` -> `Project Structure...` (or press `Ctrl+Alt+Shift+S`).
    *   In the left pane, select **Modules**.
    *   In the right pane, find your project. Ensure `src/test/java` is marked as **Test Sources Root** (blue icon). If not, right-click on `src/test/java` and select `Mark Directory as -> Test Sources Root`.
    *   Click **Apply** and then **OK**.
5.  **Invalidate Caches and Restart (if issues persist):**
    *   If you encounter persistent import errors or build issues, go to `File` -> `Invalidate Caches / Restart...`.
    *   Select `Invalidate and Restart`.

---

## How to Run the Tests

### Running UI Tests (Selenium)

1.  **Ensure Browser and Driver are Ready:**
    *   `WebDriverManager`, configured in `BaseTest.java`, will automatically download the correct ChromeDriver version for your installed Chrome browser.
2.  **Run the UI Test:**
    *   Open the `DeleteAdminTestcase.java` file (located in `src/test/java/Testcases/`).
    *   Right-click anywhere within the code editor of `OrangeHrmTest.java`.
    *   Select **Run 'DeleteAdminTestcase'**.
    *   Alternatively, you can right-click on the `testng.xml` file and select `Run 'testng.xml'` (if UI tests are included there).

### Running API Tests (REST Assured)

1.  **Run the API Test:**
    *   Open the `AddCandidateApiTest.java` file (located in `src/test/java/Testcases/`).
    *   Right-click anywhere within the code editor of `AddCandidateApiTest.java`.
    *   Select **Run 'AddCandidateApiTest'**.
    *   Alternatively, you can right-click on the `testng.xml` file and select `Run 'testng.xml'` (if API tests are included there).

### Running All Tests (Using `testng.xml`)

The `testng.xml` file orchestrates the execution of your entire test suite.

1.  **Locate `testng.xml`:** Find the `testng.xml` file (it should be in `src/main/resources` or your project root).
2.  **Run the Suite:**
    *   Right-click on the `testng.xml` file in IntelliJ.
    *   Select **Run '.../testng.xml'**.
    *   This will execute all tests defined in the XML file, including your UI and API tests.

---

## Test Scenarios Covered

### UI Automation (Selenium)

*   **Scenario:** User login and Admin user management.
*   **Steps:**
    1.  Navigate to `https://opensource-demo.orangehrmlive.com`.
    2.  Login using username `Admin` and password `admin123`.
    3.  Click the "Admin" tab on the left sidebar.
    4.  Search using the username "Admin".
    5.  Assert that the number of results, the username, the user role, and the status are correct.
    6.  Click the Delete icon for the admin user.
    7.  Assert that the admin user deletion is not allowed by verifying the "Cannot be deleted" toast message appears.

### API Automation (REST Assured)

*   **Scenario:** Add a new candidate via the API.
*   **Steps:**
    1.  Use REST Assured to add a new candidate through the API endpoint (`/web/index.php/api/v2/recruitment/candidates`).
    2.  Handle authentication properly by obtaining a session cookie via Selenium.
    3.  Assert that the HTTP status code of the API response is 200 (OK).
    4.  Assert that the response body correctly reflects the data of the newly added candidate.
