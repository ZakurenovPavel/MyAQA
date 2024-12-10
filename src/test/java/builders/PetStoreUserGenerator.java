package builders;

import pojo.PostPetStoreUser;

public class PetStoreUserGenerator {
  public static PostPetStoreUser setUserData() {
    return PostPetStoreUser
        .builder()
        .firstName("Pavel")
        .lastName("Zakurenov")
        .password("123456")
        .userStatus(1)
        .phone("8999999999")
        .id(123456)
        .email("pavelQa@test.ru")
        .username("aqaUser")
        .build();
  }

}
