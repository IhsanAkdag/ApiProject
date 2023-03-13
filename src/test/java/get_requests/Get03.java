package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 {

    /*
    Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */

    @Test
    public void get03() {
        // set the url
        String url = "https://jsonplaceholder.typicode.com/todos/23";

        // set the expected data

        // send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        // do assertion
            // 1. yol
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

            // 2. yol  body icerisinde soft assertion yapmak icin araya virgul ile yazabiliriz
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxim molestiae qui quas velit")
                        ,"completed",equalTo(false)
                        ,"userId",equalTo(21));

//              Tek body() methodu içerisinde çoklu assertion yaparak soft assertion oluşturabilirsiniz. Fail durumunda body() içerisinde Java çalışmayı durdurmaz.
//              Çoklu body() methodu ile assertion yapıldığında fail durumunda Java bir sonraki body() methodu öncesi çaılışmayı durdurur.

//              Api üzerinde Body içerisinde yer almayan değerler için herhangi bir ekstra methoda gerek duymadan assert yapılırken,
//              Body içerisinde yer alan değerler için body() methodu ile birlikte Matchers kullanılarak assert yapılır.


    }
}

















