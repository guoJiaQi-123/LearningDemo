package com.tyut.aircraft.util;

public class BaseContext {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setCurrentName(String username) {
        threadLocal.set(username);
    }

    public static String getCurrentName() {
        return threadLocal.get();
    }

    public static void removeCurrentName() {
        threadLocal.remove();
    }

}
