package get_requests;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
        (Data içerisinde firstname değeri "Aaron", lastname değeri "Chen" olan biri olmalı)
 */

   // https://restful-booker.herokuapp.com/booking?firstname=Sally&lastname=Brown


    @Test
    public void get05() {
        // set the url
        specification.
                pathParam("first", "booking").
                queryParams("firstname", "Sally", "lastname","Brown");

        // set the expected data

        // send the request and get the response
        Response response = given().spec(specification).when().get("/{first}");
        response.prettyPrint();

        // do assertion
        response.then().statusCode(200);

        // Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
        assertTrue(response.asString().contains("bookingid"));

    }
}
