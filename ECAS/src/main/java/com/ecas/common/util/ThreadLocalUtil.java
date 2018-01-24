package com.ecas.common.util;

import org.springframework.core.NamedThreadLocal;

public class ThreadLocalUtil {

    private static NamedThreadLocal<Long> TIME_THREAD_LOCAL = new NamedThreadLocal<>("TIME");

    public static long getTime() {
        return TIME_THREAD_LOCAL.get();
    }

    public static void putTime(long time) {
        TIME_THREAD_LOCAL.set(time);
    }

    public static void removeTime() {
        TIME_THREAD_LOCAL.remove();
    }
}
