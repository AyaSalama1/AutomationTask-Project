package testAPIPackage;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPostById {
	int ValidId = 90;
	int ValidUserId = 9;
	int InvalidId = 102;
	int InvalidUserId = 8;

	@Test
	public void getPostById90AndCheckStatusCodeExpectHttp200() {
		given().pathParam("Id", ValidId).when().get("https://jsonplaceholder.typicode.com/posts/{Id}").then()
				.assertThat().statusCode(200);
	}

	@Test
	public void getPostById102AndCheckStatusCodeExpectHttp404() {
		given().pathParam("Id", InvalidId).when().get("https://jsonplaceholder.typicode.com/posts/{Id}").then()
				.assertThat().statusCode(200);
	}

	@Test
	public void getPostById90AndCheckResponseBodyExpectedIdIsSameIdInUrlandCorrectUserId() {
		given().pathParam("Id", ValidId).when().get("https://jsonplaceholder.typicode.com/posts/{Id}").then()
				.assertThat().body("id", equalTo(ValidId)).and().body("userId", equalTo(ValidUserId));

	}

	@Test
	public void getPostById90AndCheckResponseBodyExpectedIdIsSameIdInUrlAndIncorrectUserId() {
		given().pathParam("Id", ValidId).when().get("https://jsonplaceholder.typicode.com/posts/{Id}").then()
				.assertThat().body("id", equalTo(ValidId)).and().body("userId", equalTo(InvalidUserId));

	}

}
