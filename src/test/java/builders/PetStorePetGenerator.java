package builders;

import java.util.List;
import pojo.Category;
import pojo.PostPetStorePet;
import pojo.TagsItem;

public class PetStorePetGenerator {
  public static PostPetStorePet setPetData() {

    Category category = new Category();
    category.setId(1);
    category.setName("Dog");

    TagsItem tag1 = new TagsItem();
    tag1.setId(1);
    tag1.setName("Friendly");

    TagsItem tag2 = new TagsItem();
    tag2.setId(2);
    tag2.setName("Playful");

    return PostPetStorePet
        .builder()
        .photoUrls(List.of("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLWd4N2COlX0srRPJcyIyzcaBDpoXIm0cylg&s"))
        .name("ChillBoy")
        .id(123456)
        .category(category)
        .tags(List.of(tag1, tag2))
        .status("available")
        .build();

  }

}
