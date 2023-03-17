package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    protected RequestSpecification specification;
    @Before
    public void setUp(){

        specification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON) // post , put , patch de kullanmak zorundayiz
                .setAccept(ContentType.JSON)
                .setBaseUri("https://jsonplaceholder.typicode.com").build();

        // setContentType(ContentType.JSON) --> post , put , patch yaparken yazmak zorundayiz
    }
}
