package apiTests;

import static apiTests.ConstantData.CREATED_PET;
import static apiTests.ConstantData.FAKE_PHONE;
import static apiTests.ConstantData.FAKE_USERNAME;
import static apiTests.ConstantData.LOGIN;
import static apiTests.ConstantData.PET;
import static apiTests.ConstantData.PHONE;
import static apiTests.ConstantData.USER;
import static apiTests.ConstantData.USERNAME;
import static builders.PetStorePetGenerator.setPetData;
import static builders.PetStoreUserGenerator.setUserData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetStoreApiTests {

  @Test
  @Order(1)
  public void postNewUserWithCode200() {
    given()
        .spec(ApiSpecifications.getPetstoreRequestSpec())
        .basePath(USER)
        .body(setUserData())
        .when().post()
        .then().assertThat().body("message", equalTo(String.valueOf(setUserData().getId())));

  }

  @Test
  @Order(2)
  public void loginUserWithCode400() {
    given()
        .spec(ApiSpecifications.getPetstoreRequestSpec())
        .basePath(LOGIN)
        .queryParam(USERNAME, FAKE_USERNAME)
        .queryParam(PHONE, FAKE_PHONE)
        .when().get()
        .then().assertThat().body("type", equalTo("unknown"));
  }

  @Test
  @Order(3)
  public void postNewPetWithCode200() {
    given()
        .spec(ApiSpecifications.getPetstoreRequestSpec())
        .basePath(PET)
        .body(setPetData())
        .when().post()
        .then().statusCode(200);
  }

  @Test
  @Order(4)
  public void findPetById() {
    given()
        .spec(ApiSpecifications.getPetstoreRequestSpec())
        .basePath(CREATED_PET)
        .when().get()
        .then().statusCode(200);
  }

  @Test
  @Order(5)
  public void deletePetById() {
    given()
        .spec(ApiSpecifications.getPetstoreRequestSpec())
        .basePath(CREATED_PET)
        .when().delete()
        .then().statusCode(200);
  }
}
