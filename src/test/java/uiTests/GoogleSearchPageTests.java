package uiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageObject.GoogleSearchPage;

public class GoogleSearchPageTests extends BaseTest {

  @BeforeAll
  public static void config() {
    Configuration.baseUrl = "https://www.google.com";
  }

  @BeforeEach
  public void setUp() {
    Selenide.open("/");
  }

  @ParameterizedTest
  @ValueSource(strings = {"qa", "aqa", "cars"})
  void testSearchQuery(String query) {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    googleSearchPage.setSearchQuery(query);
    googleSearchPage.pushSearchButton();
    googleSearchPage.isEnoughSearchResults();
  }

}
