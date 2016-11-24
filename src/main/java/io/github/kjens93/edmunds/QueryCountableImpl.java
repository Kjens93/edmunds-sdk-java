package io.github.kjens93.edmunds;

import java.util.concurrent.Future;
import java.util.function.Consumer;

import static io.github.kjens93.async.Async.async;

/**
 * Created by kjensen on 11/23/16.
 */
abstract class QueryCountableImpl implements QueryCountable {

    public final Future<Integer> countAsync(Consumer<Integer> callback) {
        return async(this::count, callback);
    }

    public final Future<Integer> countAsync() {
        return async(this::count);
    }

}
