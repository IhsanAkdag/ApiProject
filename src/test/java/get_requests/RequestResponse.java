package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {

        /*
    1)Postman manuel API testi için kullanilir.
    2)API otomasyonu için Rest-Assured Library kullanacagiz.
    3)Otomasyon kodlarının yazımı için şu adımları izliyoruz:
       a) Gereksinimleri anlama
       b) Test case i yazma:
          -Test case i yazmak için "Gherkin Language" kullaniyoruz.
           x) Given: Ön koşullar  --> Endpoint, body
           y) When : İşlemlee --> Get,Put,Delete...
           z) Then : Dönütler --> Assert
           t) And --> Çoklu işlemlerin art arda yazilacağı yerlerde kullanilir.
        c) Test kodunu yazarken şu adımları izleriz:
           i)    Set the URL
           ii)   Set the expected data
           iii)  Send the request and get the response
           iv)   Do assertion
       */
        public static void main(String[] args) {

                String url = "https://restful-booker.herokuapp.com/booking/55";

                //Get request nasıl yapılır:
                Response response = given().when().get(url);

                response.prettyPrint();//prettyPrint() methodu response datayı yazdırır.
                System.out.println("-----------------------------------");

                System.out.println("statusCode = " + response.statusCode()); // status kodu yazdiriyoruz
                System.out.println("contentType = " + response.contentType()); // content type
                System.out.println("statusLine = " + response.statusLine()); // status line
                System.out.println("-----------------------------------");

                // Header nasil yazdirilir
                System.out.println("header(\"Connection\") = " + response.header("Connection"));
                System.out.println("header(\"Server\") = " + response.header("Server"));
                System.out.println("-----------------------------------");

                //Headers
                System.out.println("headers = \n" + response.headers()); // hepsini yazdirir
                System.out.println("headers = \n" + response.getHeaders()); // hepsini yazdirir
                System.out.println("-----------------------------------");

                //Time
                System.out.println("time = " + response.getTime());
                System.out.println("-----------------------------------");


        }

}
