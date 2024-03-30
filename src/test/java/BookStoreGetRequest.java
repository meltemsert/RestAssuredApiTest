import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class BookStoreGetRequest {
    public static void main(String[] args) {

        // 1. İstek yapılacak URL'yi belirleyin
        String url= "https://demoqa.com/swagger/#/BookStore/BookStoreV1BooksGet";

        // 2. İstek başlıklarını belirleyin (opsiyonel)
        String contentType= ContentType.JSON.toString();

        Map<String,Object> header= new HashMap<>();
        header.put("Content-Type", ContentType.JSON.toString());

        // 3. GET isteğini gönderin
        Response response= RestAssured.given()
                .contentType(contentType)
                .headers(header)
                .when().log().headers()
                .get(url);

        // 5. Yanıtı işleyin ve doğrulamalar yapın
        response.then().log().all()
                .statusCode(200)
                .body("books", not(empty()));

        System.out.println("All books have been successfully received and verified!");




    }
}
