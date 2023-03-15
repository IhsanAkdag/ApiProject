package get_requests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class Odev01 {
 /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01() {
//        i)    Set the URL
        String url = "https://reqres.in/api/users/3";

//        ii)   Set the expected data

//        iii)  Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

//        iv)   Do assertion
        response.  // Dogrulanabilir response
                then().
                statusCode(200). //HTTP Status Code should be 200
                contentType(ContentType.JSON). //Content Type should be JSON
                statusLine("HTTP/1.1 200 OK"); //Status Line should be HTTP/1.1 200 OK
    }
}