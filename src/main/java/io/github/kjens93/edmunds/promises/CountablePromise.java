package io.github.kjens93.edmunds.promises;

import io.github.kjens93.promises.Promise;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by kjensen on 11/23/16.
 */
@FunctionalInterface
public interface CountablePromise {

    int getCount();

    default int getCount(int timeout, TimeUnit unit) throws TimeoutException {
        Promise<Integer> p = this::getCount;
        return p.get(timeout, unit);
    }

}
