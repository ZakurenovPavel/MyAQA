package pageObject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GitHubTopicPage {

  private static final SelenideElement resourcesButton = $(
      By.xpath("//button[contains(normalize-space(), 'Resources')]"));
  ElementsCollection topics = $$(By.xpath("//a[contains(@href,'/resources/articles')]"));

  public void pushResourcesButton() {
    resourcesButton.shouldBe(visible, Duration.ofSeconds(60)).click();
  }

  public void isValuesContained() {
    List<String> expectedValues = List.of("AI", "DevOps", "Security", "Software Development",
        "View all");
    List<String> actualValues = topics.filterBy(Condition.visible)
        .stream()
        .map(WebElement::getText).collect(
            Collectors.toList());
    Assertions.assertEquals(expectedValues, actualValues);
  }
}
