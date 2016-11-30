package io.github.kjens93.edmunds.enums;

import lombok.RequiredArgsConstructor;

/**
 * Created by kjensen on 11/20/16.
 */
@RequiredArgsConstructor
public enum View {
    BASIC("basic"),
    FULL("full");

    private final String string;

    @Override
    public String toString() {
        return string;
    }
}
