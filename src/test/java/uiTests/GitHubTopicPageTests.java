package uiTests;

import static uiTests.ConstantData.GIT;
import static uiTests.ConstantData.ROOT;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObject.GitHubTopicPage;

public class GitHubTopicPageTests extends BaseTest {


  @BeforeAll
  public static void config() {
    Configuration.baseUrl = GIT;
  }

  @BeforeEach
  public void setUp() {
    Selenide.open(ROOT);
  }

  @Test
  public void openTopics() {
    GitHubTopicPage gitHubTopicPage = new GitHubTopicPage();
    gitHubTopicPage.pushResourcesButton();
    gitHubTopicPage.isValuesContained();
    Selenide.clearBrowserCookies();
  }

}
