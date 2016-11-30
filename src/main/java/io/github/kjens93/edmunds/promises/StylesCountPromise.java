package io.github.kjens93.edmunds.promises;

import io.github.kjens93.edmunds.enums.State;

/**
 * Created by kjensen on 11/29/16.
 */
public interface StylesCountPromise extends CountablePromise {
    StylesCountPromise state(State state);
}
