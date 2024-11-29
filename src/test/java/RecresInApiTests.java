import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.GetUsersData;

public class RecresInApiTests {
  @Test
  public void getUsersWithCode200() {
    given()
        .accept(ContentType.JSON)
        .contentType(ContentType.JSON)
        .baseUri("https://reqres.in/api")
        .basePath("/users?page=2")
        .when().get()
        .then().log().body().statusCode(200);
  }

  @Test
  public void checkUserEmail() {
    List<GetUsersData> users = given()
        .accept(ContentType.JSON)
        .contentType(ContentType.JSON)
        .baseUri("https://reqres.in/api")
        .basePath("/users?page=2")
        .when().get()
        .then().log().body().extract().jsonPath().getList("data", GetUsersData.class);

    users.forEach(user -> System.out.println(user.getEmail()));
    users.forEach(user -> Assertions.assertTrue(user.getEmail().endsWith("@reqres.in")));
  }
}
