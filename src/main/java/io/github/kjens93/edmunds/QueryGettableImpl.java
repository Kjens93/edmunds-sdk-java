package io.github.kjens93.edmunds;

import java.util.concurrent.Future;
import java.util.function.Consumer;

import static io.github.kjens93.async.Async.async;

/**
 * Created by kjensen on 11/23/16.
 */
abstract class QueryGettableImpl<T> implements QueryGettable<T> {

    public final Future<T> getAsync(Consumer<T> callback) {
        return async(this::get, callback);
    }

    public final Future<T> getAsync() {
        return async(this::get);
    }

}
