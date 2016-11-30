package io.github.kjens93.edmunds.utils;

/**
 * Created by kjensen on 11/22/16.
 */
public interface Verify {

    static void verifyNotNull(Object o) {
        if (o == null) throw new NullPointerException();
    }

    static void verifyNotNull(Object o, RuntimeException exceptionToThrow) {
        if (o == null) throw exceptionToThrow;
    }

    static void verifyNotEmpty(String s, RuntimeException exceptionToThrow) {
        verifyNotNull(s, exceptionToThrow);
        if (s.isEmpty()) throw exceptionToThrow;
    }

}
