package testAPIPackage;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateAPost {
	String Title = "TestPost1";
	String Body = "TestBody1";
	int UserId = 80;

	@Test
	public void CreateAPostAndAssertResponseStatusCodeExpected201andResponseWithSameTitle() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("title", Title);
		requestParams.put("body", Body);
		requestParams.put("userId", UserId);
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.post();
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(Title, response.jsonPath().get("title"));
	}
}
