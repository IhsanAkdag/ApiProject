package get_requests;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Odev03 {
     /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void get03() {
//        i)    Set the URL
        String url = "https://reqres.in/api/users/2";

//        ii)   Set the expected data

//        iii)  Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

//        iv)   Do assertion
        response.  // Dogrulanabilir response
                then().
                statusCode(200).
                contentType(ContentType.JSON);

        //Do Assertion
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).body("data.email", hasItem("janet.weaver@reqres.in"),
                        "data.first_name", hasItem("Janet"),
                        "data.last_name", hasItems("Weaver"),
                        "support.text",hasItem("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }

}


