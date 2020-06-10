package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErrorNotificationPage {
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public void shouldVisibleNotification() {
        errorNotification.shouldBe(visible);
    }
}
