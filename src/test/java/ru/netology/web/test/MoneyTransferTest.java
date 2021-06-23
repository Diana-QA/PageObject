package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.MoneyTransfer;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

  @BeforeEach
  void setUp() {
    Configuration.browser = "chrome";
    Configuration.startMaximized = true;
  }

  @Test
  void shouldTransferMoneyBetweenOwnCards() {
    val loginPage = open("http://localhost:9999/", LoginPage.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    int balanceFirstCard = dashboardPage.getFirstCardBalance();
    int balanceSecondCard = dashboardPage.getSecondCardBalance();
    val moneyTransfer = dashboardPage.firstCardButton();
    val infoCard = DataHelper.getSecondCardNumber();
    String sum = "300";
    moneyTransfer.transferForm(sum, infoCard);
    assertEquals(balanceFirstCard + Integer.parseInt(sum), dashboardPage.getFirstCardBalance());
    assertEquals(balanceSecondCard - Integer.parseInt(sum), dashboardPage.getSecondCardBalance());
  }
}

