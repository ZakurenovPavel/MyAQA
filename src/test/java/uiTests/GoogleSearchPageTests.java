package uiTests;

import static uiTests.ConstantData.GOOGLE_URL;
import static uiTests.ConstantData.ROOT;
import static uiTests.ConstantData.searchList;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pageObject.GoogleSearchPage;

public class GoogleSearchPageTests extends BaseTest {


  @BeforeAll
  public static void config() {
    Configuration.baseUrl = GOOGLE_URL;
  }

  static Stream<String> provideSearchQueries() {
    return searchList.stream();
  }

  @BeforeEach
  public void setUp() {
    Selenide.open(ROOT);
  }

  @ParameterizedTest
  @MethodSource("provideSearchQueries")
  void testSearchQuery(String query) {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    googleSearchPage.setSearchQuery(query);
    googleSearchPage.pushSearchButton();
    googleSearchPage.isEnoughSearchResults();
    Selenide.clearBrowserCookies();
  }

}
