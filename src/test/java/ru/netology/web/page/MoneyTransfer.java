package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransfer {
    private final SelenideElement heading = $(".heading").shouldHave(Condition.text("Пополнение карты"));
    private final SelenideElement amount = $("[data-test-id=amount] input");
    private final SelenideElement from = $("[data-test-id=from] input");
    private final SelenideElement button = $("[data-test-id=action-transfer]");
    private final SelenideElement cancelButton = $("[data-test-id=action-cancel]");
    private final SelenideElement error = $("[data-test-id=error-notification]");
    private String transferAmount;
    private int cardForTranslation;

    public MoneyTransfer(String transferAmount, int cardForTranslation) {
        this.transferAmount = transferAmount;
        this.cardForTranslation = cardForTranslation;
    }

    public MoneyTransfer() {
        heading.shouldBe(Condition.visible);
    }

    public void getError() {
        error.shouldBe(Condition.visible);
    }
}
