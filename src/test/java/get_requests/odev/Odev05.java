package get_requests.odev;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Odev05 extends ReqresBaseUrl {
      /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
        }
      */

    @Test
    public void odev05() {
        // set the url
        specification.pathParams("first","api","second","unknown","third",3);

        // set the expected data

        // set the request and get the response
        Response response = given().spec(specification).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        // do assertion
        response.then().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                body("data.id",equalTo(3),
                "data.name",equalTo("true red"),
                "data.year", equalTo(2002),
                "data.color",equalTo("#BF1932"),
                "data.pantone_value",equalTo("19-1664"),
                "support.url",equalTo("https://reqres.in/#support-heading"),
                "support.text",equalTo( "To keep ReqRes free, contributions towards server costs are appreciated!"));;



    }
}
