package uiTests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import PageObject.AnimeGoLoginPage;

public class AnimegoLoginPageTests extends BaseTest {
  @Test
  public void loginOperationWithBadCredentials() {
    AnimeGoLoginPage animeGoLoginPage = new AnimeGoLoginPage();
    Selenide.open("/login");
    animeGoLoginPage.authOperation("test@yandex.ru" , "12345678");
    animeGoLoginPage.isErrorMessageDisplayed();
  }
}
