package ru.kafpin.firsttt;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String surName;
    private String patronym;
    private String phone;
    private String password;
}
