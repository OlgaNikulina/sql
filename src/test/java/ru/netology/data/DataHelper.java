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

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode() throws SQLException {
        val authCodeSQL = "SELECT  code FROM auth_codes";

        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
                val authCodeStmt = conn.prepareStatement(authCodeSQL);
        ) {
            try (val rs = authCodeStmt.executeQuery(authCodeSQL)) {
                while (rs.next()) {
                    val code = rs.getString("code");
                    System.out.println(code);
                }
            }
        }
        return new VerificationCode(authCodeSQL);
    }
}

