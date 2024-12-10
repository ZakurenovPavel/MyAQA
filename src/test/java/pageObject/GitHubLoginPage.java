package pageObject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class GitHubLoginPage {
  private static final SelenideElement userLoginInput = $(By.id("login_field"));
  private static final SelenideElement userPasswordInput = $(By.id("password"));
  private static final SelenideElement submitButton = $(By.xpath(".//input[@value='Sign in']"));
  private static final SelenideElement invalidCredErrorMessage = $(By.xpath(".//div[@class='js-flash-alert']"));
  private static final SelenideElement profileButton = $(By.xpath(".//button[@aria-label='Open user navigation menu']"));
  private static final SelenideElement logoutButton = $(By.xpath(".//a[@href='/logout']"));
  private static final SelenideElement doubleCheckLogoutButton = $(By.xpath(".//input[@value='Sign out']"));


  public void authOperation(String login, String password) {
    setUserLogin(login);
    setUserPassword(password);
    pushSubmitButton();
  }

  public void setUserLogin(String login) {
    userLoginInput.shouldBe(visible).setValue(login);
  }

  public void setUserPassword(String password) {
    userPasswordInput.shouldBe(visible).setValue(password);
  }

  public void pushSubmitButton() {
    submitButton.shouldBe(visible).click();
  }

  public void isErrorMessageDisplayed() {
    invalidCredErrorMessage.shouldBe(visible);
  }

  public void isNotErrorMessageDisplayed() {
    invalidCredErrorMessage.shouldNotBe(visible);
  }

  public void signOut() {
    pushProfileButton();
    pushLogoutButton();
    pushDoubleCheckLogoutButton();
  }

  public void pushProfileButton() {
    profileButton.shouldBe(visible).click();
  }

  public void pushLogoutButton() {
    logoutButton.shouldBe(visible).click();
  }

  public void pushDoubleCheckLogoutButton() {
    doubleCheckLogoutButton.shouldBe(visible).click();
  }
}
