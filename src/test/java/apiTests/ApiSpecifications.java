package apiTests;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import io.restassured.specification.RequestSpecification;

public class ApiSpecifications {
  public static RequestSpecification getRequestSpec() {
    return given()
        .baseUri("https://petstore.swagger.io/v2")
        .contentType(JSON)
        .accept(JSON);
  }
}
