package ru.netology.data;

import lombok.Value;
import lombok.val;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getAuthInfoWithInvalidLoginAndPassword() {
        return new AuthInfo("коля", "12345");
    }

    public static AuthInfo getAuthInfoWithEmptyFieldsLoginAndPassword() {
        return new AuthInfo(" ", " ");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode() throws SQLException {
        val authCodeSQL = "SELECT  code FROM auth_codes order by created desc limit 1;";
        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://192.168.99.100:3306/app", "app", "pass"
                );
                val authCodeStmt = conn.prepareStatement(authCodeSQL);
        ) {
            try (val rs = authCodeStmt.executeQuery(authCodeSQL)) {
                String code = "";
                while (rs.next()) {
                    code = rs.getString("code");
                }
                return new VerificationCode(code);
            }
        }
    }

    public static VerificationCode getWrongVerificationCode(){
        return new VerificationCode("1");
    }

    public static VerificationCode getEmptyVerificationCode(){
        return new VerificationCode(" ");
    }
}

