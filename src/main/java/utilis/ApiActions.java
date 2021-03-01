package utilis;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;

import java.util.Map;

public class ApiActions {

	private String baseURI = "https://backend.shifters.tech/api";

    private RequestSpecification requestSpec = new RequestSpecBuilder()
	    .setBaseUri(baseURI)
	    .log(LogDetail.ALL)
	    .build();
    private ResponseSpecification responseSpec = new ResponseSpecBuilder()
	    .expectStatusCode(200)
	    .log(LogDetail.BODY)
	    .build();
    
    @Step("Perform API Request --> [https://backend.shifters.tech/api/{endpoint}]")
    public Response performGetRequest(String endpoint) {
	Response res = RestAssured
	.given()
		.spec(requestSpec)
	.when()
		.get(endpoint)
	.then()
		.spec(responseSpec)
	.and()
		.extract().response();

	return res;

    }
    

	@Step("Perform API Request --> [https://backend.shifters.tech/api/{endpoint}]")
	public Response performPostRequest_withFormParams(String endpoint, Map<String, Object> formParams) {
		Response res = RestAssured
				.given()
				.formParams(formParams)
				.and()
				.spec(requestSpec)
				.when()
				.post(endpoint)
				.then()
				.spec(responseSpec)
				.and()
				.extract().response();

		return res;

	}

    @Step("Perform API Request --> [https://backend.shifters.tech/api/{endpoint}]")
    public Response performPostRequest_withFormParamsAndHeaders(String endpoint, Map<String, Object> formParams,
	    Map<String, Object> headers) {
	Response res = RestAssured
	.given()
		.formParams(formParams)
		.headers(headers)
	.and()
		.spec(requestSpec)
	.when()
		.post(endpoint)
	.then()
		.spec(responseSpec)
	.and()
		.extract().response();

	return res;

    }

}
