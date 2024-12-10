package pageObject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import org.openqa.selenium.By;

public class GitHubTopicPage {
  private static final SelenideElement resourcesButton = $(By.xpath("//button[contains(normalize-space(), 'Resources')]"));
  ElementsCollection topics = $$(By.xpath("//a[contains(@href,'/resources/articles')]"));

  public void pushResourcesButton() {
    resourcesButton.shouldBe(visible, Duration.ofSeconds(60)).click();
  }

  public void isValuesContained() {
    String[] expectedValues = {"AI", "DevOps", "Security", "Software Development", "View All"};
    for (String value : expectedValues) {
      topics.findBy(Condition.text(value)).shouldBe(visible);
    }
  }
}
