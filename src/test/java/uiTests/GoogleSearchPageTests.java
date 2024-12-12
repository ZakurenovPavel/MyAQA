package uiTests;

import static uiTests.ConstantData.GOOGLE;
import static uiTests.ConstantData.ROOT;
import static uiTests.ConstantData.list;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pageObject.GoogleSearchPage;

public class GoogleSearchPageTests extends BaseTest {



  @BeforeAll
  public static void config() {
    Configuration.baseUrl = GOOGLE;
  }

  @BeforeEach
  public void setUp() {
    Selenide.open(ROOT);
  }

  static Stream<String> provideSearchQueries() {
    return list.stream();
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
