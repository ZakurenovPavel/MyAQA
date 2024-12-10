package uiTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

  @BeforeAll
  public static void setConfiguration() {
    Configuration.browser = "chrome";
    Configuration.screenshots = false;
    Configuration.savePageSource = false;
  }

}
