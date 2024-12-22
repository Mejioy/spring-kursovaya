package ru.kafpin.firsttt;

public class GetUserPassword {
    public static void main(String[] args) {

        System.out.printf("Пароль для %s - %s%n","user1", new WebSecurityConfig().passwordEncoder().encode("user1"));
        System.out.printf("Пароль для %s - %s%n","user2", new WebSecurityConfig().passwordEncoder().encode("user2"));
        System.out.printf("Пароль для %s - %s%n","user3", new WebSecurityConfig().passwordEncoder().encode("user3"));

    }
}
