package ru.prusakova.logingstarter;

public class LoggingStarterAutoConfiguration {
    public static void println(String str) {
        System.out.println("Вызвано из gradle " + str);
    }
}
