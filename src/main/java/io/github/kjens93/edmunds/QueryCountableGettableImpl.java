package io.github.kjens93.edmunds;

import java.util.concurrent.Future;
import java.util.function.Consumer;

import static io.github.kjens93.async.Async.async;

/**
 * Created by kjensen on 11/23/16.
 */
abstract class QueryCountableGettableImpl<T> implements QueryCountableGettable<T> {

    public final Future<T> getAsync(Consumer<T> callback) {
        return async(this::get, callback);
    }

    public final Future<T> getAsync() {
        return async(this::get);
    }

    public final Future<Integer> countAsync(Consumer<Integer> callback) {
        return async(this::count, callback);
    }

    public final Future<Integer> countAsync() {
        return async(this::count);
    }

}
