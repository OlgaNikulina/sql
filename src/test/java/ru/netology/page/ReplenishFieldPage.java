package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReplenishFieldPage {
    private SelenideElement replenishNotificationLogin = $("[data-test-id=login] .input__sub");
    private SelenideElement replenishNotificationPassword = $("[data-test-id=password] .input__sub");
    private SelenideElement replenishNotificationCode = $("[data-test-id=code] .input__sub");

    public void shouldVisibleNotification() {
        replenishNotificationLogin.shouldBe(visible);
        replenishNotificationPassword.shouldBe(visible);
    }

    public void shouldVisibleNotificationCode() {
        replenishNotificationCode.shouldBe(visible);
    }
}
