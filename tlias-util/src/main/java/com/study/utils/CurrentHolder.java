package com.study.utils;

/**
 * @author KM
 */
public class CurrentHolder {
    private static final ThreadLocal<Integer> CURRENT_LOCAL  = new ThreadLocal<>();

    public static void set(Integer employeeId) {
        CURRENT_LOCAL.set(employeeId);
    }

    public static Integer get() {
        return CURRENT_LOCAL.get();
    }

    public static void remove() {
        CURRENT_LOCAL.remove();
    }
}
