package apiTests;

import static apiTests.ConstantData.PETSTORE;
import static apiTests.ConstantData.REQRES_IN_API;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import io.restassured.specification.RequestSpecification;

public class ApiSpecifications {

  public static RequestSpecification getPetstoreRequestSpec() {
    return given()
        .baseUri(PETSTORE)
        .contentType(JSON)
        .accept(JSON);
  }

  public static RequestSpecification getReqresInRequestSpec() {
    return given()
        .baseUri(REQRES_IN_API)
        .contentType(JSON)
        .accept(JSON);
  }

}
