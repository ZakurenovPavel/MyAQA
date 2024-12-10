package uiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import pageObject.GitHubContactSalesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GitHubContactSalesPageTests extends BaseTest {

  @BeforeAll
  public static void config() {
    Configuration.baseUrl = "https://www.github.com";
  }

  @BeforeEach
  public void setUp() {
    Selenide.open("/");
  }

  @Test
  public void loginOperation () {
    GitHubContactSalesPage gitHubContactSalesPage = new GitHubContactSalesPage();
    gitHubContactSalesPage.authOperation("Pavel", "Zakurenov");
    gitHubContactSalesPage.isDataRelated("Pavel", "Zakurenov");

  }
}
