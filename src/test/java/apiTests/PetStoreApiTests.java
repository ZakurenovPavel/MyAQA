package apiTests;

import static builders.PetStorePetGenerator.setPetData;
import static builders.PetStoreUserGenerator.setUserData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

import io.restassured.specification.RequestSpecification;
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
    requestSpec = ApiSpecifications.getRequestSpec();
  }

  @Test
  @Order(1)
  public void postNewUserWithCode200() {
    given()
        .spec(requestSpec)
        .basePath("/user")
        .body(setUserData())
        .when().post()
        .then().assertThat().body("message", equalTo(String.valueOf(setUserData().getId())));

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
        .then().assertThat().body("type", equalTo("unknown"));
  }

  @Test
  @Order(3)
  public void postNewPetWithCode200() {
    given()
        .spec(requestSpec)
        .basePath("/pet")
        .body(setPetData())
        .when().post()
        .then().statusCode(200);
  }

  @Test
  @Order(4)
  public void findPetById() {
    given()
        .spec(requestSpec)
        .basePath("/pet/123456")
        .when().get()
        .then().statusCode(200);
  }

  @Test
  @Order(5)
  public void deletePetById() {
    given()
        .spec(requestSpec)
        .basePath("/pet/123456")
        .when().delete()
        .then().statusCode(200);
  }
}
