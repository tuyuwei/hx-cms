package com.hx.cms.context;

import com.alibaba.ttl.TransmittableThreadLocal;

public class UserContextHolder {

    private final static TransmittableThreadLocal<UserContext> threadLocal = new TransmittableThreadLocal<>();

    public static void buildContext(UserContext context) {
        threadLocal.set(context);
    }

    public static UserContext getUserContext() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
