package ru.netology.mode;

import lombok.Value;

@Value
public class User {
    private int id;
    private String login;
    private String password;
    private String status;
}
