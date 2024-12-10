package uiTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pageObject.GitHubLoginPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GitHubLoginPageTests extends BaseTest {

  @BeforeAll
  public static void config() {
    Configuration.baseUrl = "https://www.github.com";
  }

  @BeforeEach
  public void setUp() {
    Selenide.open("/login");
  }

  @Test
  public void loginOperationWithBadCredentials() {
    GitHubLoginPage gitHubLoginPage = new GitHubLoginPage();
    gitHubLoginPage.authOperation("test@yandex.ru", "12345678");
    gitHubLoginPage.isErrorMessageDisplayed();
  }

  @Test
  public void loginOperationWithGoodCredentials() {
    GitHubLoginPage gitHubLoginPage = new GitHubLoginPage();
    gitHubLoginPage.authOperation("Pavel2030", "StrongPassword2030");
    gitHubLoginPage.isNotErrorMessageDisplayed();
    Selenide.clearBrowserCookies();
    //gitHubLoginPage.signOut();
  }
}
