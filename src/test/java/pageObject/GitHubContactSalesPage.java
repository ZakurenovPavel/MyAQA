package pageObject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class GitHubContactSalesPage {

  private static final SelenideElement solutionsButton = $(
      By.xpath("//button[contains(normalize-space(), 'Solutions')]"));
  private static final SelenideElement ciCdButton = $(
      By.xpath("//a[@href='/solutions/use-case/ci-cd']"));
  private static final SelenideElement contactSalesButton = $(By.xpath(
      ".//a[@href='https://github.com/enterprise/contact?ref_cta=Contact+sales&ref_loc=hero&ref_page=%2Fsolutions_usecase_cicd']"));
  private static final SelenideElement userFirstNameInput = $(By.name("first_name"));
  private static final SelenideElement userLastNameInput = $(By.name("last_name"));


  public void authOperation(String firstName, String lastName) {
    pushSolutionsButton();
    pushCiCdButton();
    pushContactSalesButton();
    setUserFirstName(firstName);
    setUserLastName(lastName);
  }

  public void pushSolutionsButton() {
    solutionsButton.shouldBe(visible).click();
  }

  public void pushCiCdButton() {
    ciCdButton.shouldBe(visible).click();
  }

  public void pushContactSalesButton() {
    contactSalesButton.shouldBe(visible).click();
  }

  public void setUserFirstName(String firstName) {
    userFirstNameInput.shouldBe(visible).setValue(firstName);
  }

  public void setUserLastName(String lastName) {
    userLastNameInput.shouldBe(visible).setValue(lastName);
  }

  public void isDataRelated(String firstName, String lastName) {
    userFirstNameInput.shouldHave(Condition.exactValue(firstName));
    userLastNameInput.shouldHave(Condition.exactValue(lastName));
  }

}
