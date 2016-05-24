package com.june.implemented.common.util;

import java.lang.reflect.Constructor;

import com.june.common.exception.SystemException;

public class ClassUtil {
    public static Object newInstance(String clz) throws SystemException {
        try {
            return Class.forName(clz).newInstance();
        } catch (Exception e) {
            throw new SystemException("Unable to initiate class " + clz, e);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Object newInstance(String clz, Object... args) throws SystemException {
        try {
            Class c = Class.forName(clz);
            Class[] paramsTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                paramsTypes[i] = args[i].getClass();
            }
            Constructor ctr = c.getConstructor(paramsTypes);
            return ctr.newInstance(args);
        } catch (Exception e) {
            throw new SystemException("Unable to initiate class " + clz, e);
        }
    }
}
