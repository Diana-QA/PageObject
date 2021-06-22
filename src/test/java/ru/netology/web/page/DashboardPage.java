package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private final SelenideElement heading = $("[data-test-id=dashboard]");
  private final SelenideElement firstCard = $("[data-test-id=92df3f1c-a033-48e6-8390-206f6b1f56c0] > [data-test-id=action-deposit]");
  private final SelenideElement secondCard = $("[data-test-id=0f3f5c2a-249e-4c3d-8287-09f7a039391d] > [data-test-id=action-deposit]");
  private final SelenideElement reload = $("[data-test-id=action-reload]");
  private final SelenideElement firstCardButton = $$("[data-test-id=action-deposit]").first();
  private final SelenideElement secondCardButton = $$("[data-test-id=action-deposit]").last();
  private final String balanceStart = "баланс: ";
  private final String balanceFinish = " р.";

  public DashboardPage() {
    heading.shouldBe(visible);
    firstCard.shouldBe(visible);
    secondCard.shouldBe(visible);
    reload.shouldBe(visible);
  }

  public MoneyTransfer firstCardButton() {
    firstCardButton.click();
    return new MoneyTransfer();
  }

  public MoneyTransfer secondCardButton() {
    secondCardButton.click();
    return new MoneyTransfer();
  }

  public int getFirstCardBalance() {
    val text = firstCard.text();
    return extractBalanceCard1(text);
  }

  private int extractBalanceCard1(String text) {
    val start = text.indexOf(balanceStart);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);
  }

  public int getSecondCardBalance() {
    val text = secondCard.text();
    return extractBalanceCard2(text);
  }

  private int extractBalanceCard2(String text) {
    val start = text.indexOf(balanceStart);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);
  }
}
