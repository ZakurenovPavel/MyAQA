package apiTests;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.GetUnknownsData;
import pojo.GetUsersData;

public class ReqresInApiTests {

  private RequestSpecification requestSpec;

  @BeforeEach
  public void setUp() {
    requestSpec = given()
        .accept(JSON)
        .contentType(JSON)
        .baseUri("https://reqres.in/api");
  }

  @Test
  public void getUsersWithCode200() {
    given()
        .spec(requestSpec)
        .basePath("/users?page=2")
        .when().get()
        .then().log().body().statusCode(200);
  }

  @Test
  public void checkUserEmail() {
    List<GetUsersData> users = given()
        .spec(requestSpec)
        .basePath("/users?page=2")
        .when().get()
        .then().log().body().extract().jsonPath().getList("data", GetUsersData.class);

    users.forEach(user -> System.out.println(user.getEmail()));
    users.forEach(user -> Assertions.assertTrue(user.getEmail().endsWith("@reqres.in")));
  }

  @Test
  public void checkUnknownYear() {
    List<GetUnknownsData> unknowns = given()
        .spec(requestSpec)
        .basePath("/unknown")
        .when().get()
        .then().log().body().extract().jsonPath().getList("data", GetUnknownsData.class);

    unknowns.forEach(unknown -> System.out.println(unknown.getYear()));
    unknowns.forEach(unknown -> Assertions.assertTrue(unknown.getYear() >= 2000));
  }

  @Test
  public void checkUserAvatar() {
    List<GetUsersData> users = given()
        .spec(requestSpec)
        .basePath("/users")
        .when().get()
        .then().log().body().extract().jsonPath().getList("data", GetUsersData.class);

    users.forEach(user -> System.out.println(user.getAvatar()));
    users.forEach(user -> Assertions.assertTrue(user.getAvatar().contains("https://reqres.in")));
  }
}
