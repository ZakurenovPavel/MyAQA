package pageObject;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class GoogleSearchPage {

  private static final SelenideElement searchQueryInput = $(
      By.xpath(".//textarea[@aria-label='Найти']"));
  private static final SelenideElement searchButton = $(By.xpath(".//input[@role='button']"));
  ElementsCollection results = $$(By.xpath(".//span[@jscontroller and @jsaction and not(@style)]"));


  public void setSearchQuery(String searchQuery) {
    searchQueryInput.shouldBe(visible).setValue(searchQuery);
  }

  public void pushSearchButton() {
    searchButton.shouldBe(visible).click();
  }

  public void isEnoughSearchResults() {
    results.shouldHave(sizeGreaterThan(5));
  }


}
