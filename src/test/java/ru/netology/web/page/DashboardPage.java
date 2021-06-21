package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
  private final SelenideElement heading = $("[data-test-id=dashboard]");
  private final SelenideElement firstCard = $("[data-test-id=92df3f1c-a033-48e6-8390-206f6b1f56c0] > [data-test-id=action-deposit]");
  private final SelenideElement secondCard = $("[data-test-id=0f3f5c2a-249e-4c3d-8287-09f7a039391d] > [data-test-id=action-deposit]");

  public DashboardPage() {
    heading.shouldBe(visible);
    firstCard.shouldBe(Condition.visible);
    secondCard.shouldBe(Condition.visible);
  }




}
