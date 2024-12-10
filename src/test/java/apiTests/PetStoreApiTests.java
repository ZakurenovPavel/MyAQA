package apiTests;

import static builders.PetStorePetGenerator.setPetData;
import static builders.PetStoreUserGenerator.setUserData;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetStoreApiTests {

  private RequestSpecification requestSpec;

  @BeforeEach
  public void setUp() {
    requestSpec = given()
        .baseUri("https://petstore.swagger.io/v2")
        .contentType(JSON)
        .accept(JSON);
  }

  @Test
  @Order(1)
  public void postNewUserWithCode200() {
    given()
        .spec(requestSpec)
        .basePath("/user")
        .body(setUserData())
        .when().post()
        .then().assertThat().body("message", CoreMatchers.equalTo(String.valueOf(setUserData().getId())));

  }

  @Test
  @Order(2)
  public void loginUserWithCode400() {
    given()
        .spec(requestSpec)
        .basePath("/user/login")
        .queryParam("username", "aqaUser")
        .queryParam("phone", "1234567")
        .when().get()
        .then().assertThat().body("type", CoreMatchers.equalTo("unknown"));
  }

  @Test
  @Order(3)
  public void postNewPetWithCode200() {
    given()
        .spec(requestSpec)
        .basePath("/pet")
        .body(setPetData())
        .when().post()
        .then().log().body().statusCode(200);
  }

  @Test
  @Order(4)
  public void findPetById() {
    given()
        .spec(requestSpec)
        .basePath("/pet/123456")
        .when().get()
        .then().log().body().statusCode(200);
  }

  @Test
  @Order(5)
  public void deletePetById() {
    given()
        .spec(requestSpec)
        .basePath("/pet/123456")
        .when().delete()
        .then().log().body().statusCode(200);
  }
}
