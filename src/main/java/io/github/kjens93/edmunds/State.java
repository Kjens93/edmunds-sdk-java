package io.github.kjens93.edmunds;

import lombok.RequiredArgsConstructor;

/**
 * Created by kjensen on 11/20/16.
 */
@RequiredArgsConstructor
public enum State {
    NEW("new"),
    USED("used"),
    FUTURE("future");

    private final String string;

    @Override
    public String toString() {
        return string;
    }
}
