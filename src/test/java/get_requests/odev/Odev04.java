package get_requests.odev;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Odev04 extends HerOkuAppBaseUrl {
/*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */

    @Test
    public void get05() {
        // set the url
        specification.
                pathParam("first", "booking").
                queryParams("firstname", "Almedin", "lastname","Alikadic");

        // set the expected data

        // send the request and get the response
        Response response = given().spec(specification).when().get("/{first}");
        response.prettyPrint();

        // do assertion
        response.then().statusCode(200);
//
        // Among the data there should be someone whose firstname is "Almedin" and last name is "Alikadic"
        assertTrue(response.asString().contains("bookingid"));

    }
}
