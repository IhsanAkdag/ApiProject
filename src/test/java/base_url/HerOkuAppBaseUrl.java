package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {
    protected RequestSpecification specification;
    @Before
    public void setUp(){

        specification = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}
