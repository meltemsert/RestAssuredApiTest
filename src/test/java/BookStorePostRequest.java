import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BookStorePostRequest {

    public static void main(String[] args) {

        // 1. İstek yapılacak URL'yi belirleyin
        String url = "https://demoqa.com/swagger/#/BookStore/BookStoreV1BooksPost";

        // 2. İstek gövdesini ve başlığını oluşturun ve gerektiğinde parametreleri ekleyin
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", ContentType.JSON.toString());

        String requestBody = "{\n" +
                "  \"isbn\": \"9781449312173\",\n" +
                "  \"title\": \"Java Testing with JUnit\",\n" +
                "  \"subTitle\": \"Simple, Rapid, Effective, and Scalable Testing\",\n" +
                "  \"author\": \"Brian Okken\",\n" +
                "  \"publishDate\": \"2017-11-20\",\n" +
                "  \"publisher\": \"O'Reilly Media\",\n" +
                "  \"pages\": 302,\n" +
                "  \"description\": \"The JUnit framework makes it easy to write small tests, yet scales to support complex functional testing for Java applications and libraries. This book, authored by Brian Okken, author of the popular Python Testing with pytest, will teach you best practices and effective testing techniques in Java, using the JUnit framework.\",\n" +
                "  \"website\": \"https://www.oreilly.com/library/view/java-testing-with/9781680502848/\"\n" +
                "}";

        // 2. İstek başlıklarını belirleyin (opsiyonel)
        String contentType = ContentType.JSON.toString();

        // 4. POST isteğini gönderin
        Response response = RestAssured.given()
                .contentType(contentType)
                .headers(headers)
                .body(requestBody)
                .when().log().headers()
                .post(url);

        // 5. Yanıtı işleyin ve doğrulamalar yapın
        response.then().log().all();

        //  GetUserResponse getUserResponse= response.body().as(GetUserResponse.class);

        assertThat(response.statusCode()).isEqualTo(200);
//        assertThat(response.contentType()).isEqualTo("application/json");
//        assertThat(response.jsonPath().getString("title")).isEqualTo("Java Testing with JUnit");
//        assertThat(response.jsonPath().getString("author")).isEqualTo("Brian Okken");

        int statusCode = response.getStatusCode();
        if (statusCode == 200) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Adding book failed. Response code: " + statusCode);
        }


    }

}
