package ru.kafpin.firsttt;

public class GetUserPassword {
    public static void main(String[] args) {
        String pass = "user";
        System.out.printf("Пароль для %s - %s%n",pass, new WebSecurityConfig().passwordEncoder().encode(pass));
    }
}
