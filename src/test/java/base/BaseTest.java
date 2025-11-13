package base;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Config;

public class BaseTest {

	public static RequestSpecification getRequestSpecification() {
		return new RequestSpecBuilder()
				.setBaseUri(Config.BASE_URI)
				.addHeader("Authorization","Bearer "+Config.BEARER_TOKEN)
				.setContentType(ContentType.JSON)
				.build();
				          
		            
	}
}
