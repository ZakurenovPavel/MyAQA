package PageObject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class AnimeGoLoginPage {
  private static final SelenideElement userLoginInput = $(By.id("username"));
  private static final SelenideElement userPasswordInput = $(By.id("password"));
  private static final SelenideElement submitButton = $(By.xpath("//button[text()='Войти']"));
  private static final SelenideElement invalidCredErrorMessage = $(By.xpath(".//div[text()='Недействительные аутентификационные данные.']"));

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
}


