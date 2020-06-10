package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @Test
    void shouldLogin() throws SQLException {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCode();
        val dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.shouldVisibleDashboard();
    }

    @Test
    void shouldNotLoginWithInvalidLoginAndPassword(){
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfoWithInvalidLoginAndPassword();
        val errorNotificationPage = loginPage.invalidLoginAndPassword(authInfo);
        errorNotificationPage.shouldVisibleNotification();
    }

    @Test
    void shouldNotLoginWithInvalidCode(){
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getWrongVerificationCode();
        val errorNotificationPage = verificationPage.shouldNotValidVerify(verificationCode);
        errorNotificationPage.shouldVisibleNotification();
    }

    @Test
    void shouldNotLoginWithEmptyFieldsLoginAndPassword(){
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfoWithEmptyFieldsLoginAndPassword();
        val replenishFieldPage = loginPage.emptyFieldsLoginAndPassword(authInfo);
        replenishFieldPage.shouldVisibleNotification();
    }

    @Test
    void shouldNotLoginWithEmptyFieldCode(){
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getEmptyVerificationCode();
        val replenishFieldPage = verificationPage.shouldNotValidVerifyWithEmptyCode(verificationCode);
        replenishFieldPage.shouldVisibleNotificationCode();
    }
}
