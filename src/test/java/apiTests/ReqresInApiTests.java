package apiTests;

import static apiTests.ConstantData.REQRES_IN;
import static apiTests.ConstantData.UNKNOWN;
import static apiTests.ConstantData.USERS;
import static apiTests.ConstantData.USERS_PAGE2;
import static io.restassured.RestAssured.given;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.GetUnknownsData;
import pojo.GetUsersData;

public class ReqresInApiTests {

  @Test
  public void getUsersWithCode200() {
    given()
        .spec(ApiSpecifications.getReqresInRequestSpec())
        .basePath(USERS_PAGE2)
        .when().get()
        .then().log().body().statusCode(200);
  }

  @Test
  public void checkUserEmail() {
    List<GetUsersData> users = given()
        .spec(ApiSpecifications.getReqresInRequestSpec())
        .basePath(USERS_PAGE2)
        .when().get()
        .then().log().body().extract().jsonPath().getList("data", GetUsersData.class);

    users.forEach(user -> System.out.println(user.getEmail()));
    users.forEach(user -> Assertions.assertTrue(user.getEmail().endsWith("@reqres.in")));
  }

  @Test
  public void checkUnknownYear() {
    List<GetUnknownsData> unknowns = given()
        .spec(ApiSpecifications.getReqresInRequestSpec())
        .basePath(UNKNOWN)
        .when().get()
        .then().log().body().extract().jsonPath().getList("data", GetUnknownsData.class);

    unknowns.forEach(unknown -> System.out.println(unknown.getYear()));
    unknowns.forEach(unknown -> Assertions.assertTrue(unknown.getYear() >= 2000));
  }

  @Test
  public void checkUserAvatar() {
    List<GetUsersData> users = given()
        .spec(ApiSpecifications.getReqresInRequestSpec())
        .basePath(USERS)
        .when().get()
        .then().log().body().extract().jsonPath().getList("data", GetUsersData.class);

    users.forEach(user -> System.out.println(user.getAvatar()));
    users.forEach(user -> Assertions.assertTrue(user.getAvatar().contains(REQRES_IN)));
  }
}
