package TestCases;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import api.Payloads.Candidate;

import static io.restassured.RestAssured.given;

public class ApiClient {

    /**
     * Adds a new candidate via the API.
     * @param requestSpec The configured RestAssured RequestSpecification.
     * @param candidate The Candidate POJO to send as the payload.
     * @return The Response object from the API call.
     */
    public Response addCandidate(RequestSpecification requestSpec, Candidate candidate) {
        return given()
                .spec(requestSpec) // Use the pre-configured request spec
                .body(candidate)
                .when()
                .post("/web/index.php/api/v2/recruitment/candidates");
    }
}