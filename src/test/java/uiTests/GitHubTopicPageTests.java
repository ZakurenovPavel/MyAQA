package uiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObject.GitHubTopicPage;

public class GitHubTopicPageTests extends BaseTest {

  @BeforeAll
  public static void config() {
    Configuration.baseUrl = "https://www.github.com";
  }

  @BeforeEach
  public void setUp() {
    Selenide.open("/");
  }

  @Test
  public void openTopics() {
    GitHubTopicPage gitHubTopicPage = new GitHubTopicPage();
    gitHubTopicPage.pushResourcesButton();
    gitHubTopicPage.isValuesContained();
  }

}
