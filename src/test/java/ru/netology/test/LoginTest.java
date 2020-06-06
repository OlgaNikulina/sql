package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @Test
    void shouldLogin() throws SQLException {
        val loginPage = open("http://localhost:9999)", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCode();
        val dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.shouldVisibleDashboard();
    }
}
