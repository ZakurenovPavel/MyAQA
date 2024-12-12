package uiTests;

import static uiTests.ConstantData.FIRST_NAME;
import static uiTests.ConstantData.GIT_URL;
import static uiTests.ConstantData.LAST_NAME;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import pageObject.GitHubContactSalesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GitHubContactSalesPageTests extends BaseTest {


  @BeforeAll
  public static void config() {
    Configuration.baseUrl = GIT_URL;
  }

  @BeforeEach
  public void setUp() {
    Selenide.open(ConstantData.ROOT);
  }

  @Test
  public void loginOperation() {
    GitHubContactSalesPage gitHubContactSalesPage = new GitHubContactSalesPage();
    gitHubContactSalesPage.authOperation(FIRST_NAME, LAST_NAME);
    gitHubContactSalesPage.isDataRelated(FIRST_NAME, LAST_NAME);
    Selenide.clearBrowserCookies();
  }
}
