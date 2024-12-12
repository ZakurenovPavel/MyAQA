package uiTests;

import static uiTests.ConstantData.BAD_LOGIN;
import static uiTests.ConstantData.BAD_PASSWORD;
import static uiTests.ConstantData.GIT_URL;
import static uiTests.ConstantData.GOOD_LOGIN;
import static uiTests.ConstantData.GOOD_PASSWORD;
import static uiTests.ConstantData.LOGIN;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pageObject.GitHubLoginPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GitHubLoginPageTests extends BaseTest {


  @BeforeAll
  public static void config() {
    Configuration.baseUrl = GIT_URL;
  }

  @BeforeEach
  public void setUp() {
    Selenide.open(LOGIN);
  }

  @Test
  public void loginOperationWithBadCredentials() {
    GitHubLoginPage gitHubLoginPage = new GitHubLoginPage();
    gitHubLoginPage.authOperation(BAD_LOGIN, BAD_PASSWORD);
    gitHubLoginPage.isErrorMessageDisplayed();
    Selenide.clearBrowserCookies();
  }

  @Test
  public void loginOperationWithGoodCredentials() {
    GitHubLoginPage gitHubLoginPage = new GitHubLoginPage();
    gitHubLoginPage.authOperation(GOOD_LOGIN, GOOD_PASSWORD);
    gitHubLoginPage.isNotErrorMessageDisplayed();
    Selenide.clearBrowserCookies();
  }
}
