package TestCases;

import com.github.javafaker.Faker;
import api.Payloads.Candidate;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddCandidateApiTest extends ApiBaseTest {

    @Test
    public void testAddCandidateViaApi() {
        SoftAssert softAssert = new SoftAssert();

        // ARRANGE
        Candidate newCandidate = new Candidate();
        Faker faker = new Faker();
        newCandidate.setFirstName(faker.name().firstName());
        newCandidate.setMiddleName("");
        newCandidate.setLastName(faker.name().lastName());
        newCandidate.setEmail(faker.internet().emailAddress());

        System.out.println("Attempting to add candidate via API: " + newCandidate.getFirstName() + " " + newCandidate.getLastName());

        // ACT
        ApiClient apiClient = new ApiClient();
        Response response = apiClient.addCandidate(requestSpec, newCandidate); // Use the requestSpec from ApiBaseTest

        // ASSERT
        // Assert HTTP status code
        softAssert.assertEquals(response.getStatusCode(), 200, "API call to add candidate should return 200 OK.");

        // Assert response body details
        String responseFirstName = response.jsonPath().getString("data.firstName");
        String responseLastName = response.jsonPath().getString("data.lastName");

        softAssert.assertEquals(responseFirstName, newCandidate.getFirstName(), "API response firstName mismatch.");
        softAssert.assertEquals(responseLastName, newCandidate.getLastName(), "API response lastName mismatch.");

        // Use assertAll() to report any collected failures
        softAssert.assertAll();
    }
}