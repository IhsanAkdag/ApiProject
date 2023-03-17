package get_requests;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get10 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/127758
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
 {
    "meta": null,
    "data": {
        "id": 128529,
        "name": "Anamika Joshi",
        "email": "anamika_joshi@corkery-ritchie.info",
        "gender": "male",
        "status": "active"
    }
}
     */

    @Test
    public void name() {
        //Set the URL
        specification.pathParams("first", "users","second",128529);

        //Set the expected data
        GoRestTestData obj = new GoRestTestData();
        Map<String, String> dataMap = obj.gorestdataMapMethod("Anamika Joshi","anamika_joshi@corkery-ritchie.info","male","active");

        Map<String, Object> expectedData = obj.expectedDataMethod(null,dataMap);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(specification).get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        //ÖDEV: 500 hatası nedeniyle verildi...

    }
}











