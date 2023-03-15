package get_requests;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class Odev02 {
/*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */


    @Test
    public void get01() {
//        i)    Set the URL
        String url = "https://reqres.in/api/users/23";

//        ii)   Set the expected data

//        iii)  Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

//        iv)   Do assertion
        response.  // Dogrulanabilir response
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");

        //Server is "Cowboy"
        assertEquals("cloudflare",response.header("Server"));

        //Response body should be empty
        assertEquals("{}",response.getBody().asString());
    }
}