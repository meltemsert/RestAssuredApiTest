import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserPostRequest {

    public static void main(String[] args) {

        String url ="https://demoqa.com/Account/v1/User";

        String contentType= ContentType.JSON.toString();

        Map<String,Object> header= new HashMap<>();
        header.put("Content-Type", ContentType.JSON.toString());

        String requestBody = "{\n" +
                "\"userName\": \"string\",\n" +
                "\"password\": \"string\"\n" +
                "}";


        Response response= RestAssured.given()
                .contentType(contentType)
                .headers(header)
                .body(requestBody)
                .when().log().headers()
                .post(url);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.contentType()).isEqualTo("application/json");
        assertThat(response.jsonPath().getString("userName")).isEqualTo("Meltem");
        assertThat(response.jsonPath().getString("password")).isEqualTo("123456");

        String userID = response.jsonPath().getString("userID");
        System.out.println(userID);

        // Check if userID is not null
        assertThat(userID).isNotNull();
    }
    }








